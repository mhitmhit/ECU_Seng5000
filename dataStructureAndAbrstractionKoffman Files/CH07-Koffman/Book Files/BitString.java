package KW.CH07;

import java.util.Arrays;
import static KW.CH07.BitSequence.index;
import static KW.CH07.BitSequence.mask;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *  A class to represent a string of bits. This class is like
 *  the String except that the contents is a sequence of 0's and 1's. 
 *  BitSrings are are varying length and are immutable.
 *  @author Koffman and Wolfgang
 */
public class BitString implements BitSequence {

    /** Array of bytes to hold the data */
    final byte[] theData;
    /** Current number of meaningful bits */
    final int size;
    
    /**
     * Construct an empty BitString.
     */
    public BitString() {
        size = 0;
        theData = new byte[1];
    }
    
    /**
     * Construct a BitSring with specified contents and size.
     * Note that this is a package private constructor.
     * @param data The data
     * @param size The size
     */
    BitString(byte[] data, int size) {
        this.theData = data;
        this.size = size;
    }

    /**
     * Construct a BitString that is a copy of an
     * existing BitString.
     * @param original the original BitString
     */
    public BitString(BitString original) {
        size = original.size;
        theData = Arrays.copyOf(original.theData, original.theData.length);
    }
    
    /**
     * Construct a BitString that contains the bits of a char.
     * The char is converted to UTF-8 and the resulting bits as a BitString.
     * @param c The char to be converted.
     */
    public BitString(char c) {
    	if (c <= '\u007F') { // 7 bits in code point
    		theData = new byte[1];
    		theData[0] = (byte)(c & 0xFF);
    		size = 8;
    	} else // 11 bits in code point
    	if ('\u0080' <= c && c <= '\u07FF') {
    		theData = new byte[2];
    		theData[1] = (byte)((c & 0x3F) + 0x080);
    		theData[0] = (byte)(((c >> 6) & 0x1F) + 0x0C0);
    		size = 16;
    	} else { // 16 bits in code point (includes utf-16 coded
    		theData = new byte[3];
    		theData[2] = (byte)((c & 0x3F) + 0x080);
    		theData[1] = (byte)(((c >> 6) & 0x3F) + 0x080);
    		theData[0] = (byte)(((c >> 12) & 0x0F) + 0x0E0);
    		size = 24;
    	}
    }
    
    /**
     * Convert this BitString to a char. The BitString is assumed to encode
     * the character in UTF-8.
     * @return The char equivalent of this BitString
     */
    public char toChar() {
    	IteratorOfBoolean itr = BitSequence.iterator(this);
    	return extractChar(itr);
    }
    
    /**
     * Extract the next bits and convert into a char. The bits are 
     * coded in UTF-8.
     * @param itr The BitSequence.Iterator referencing the starting bit
     * @return The char value of the bits starting at bit itr.
     */
    public static char extractChar(IteratorOfBoolean itr) {
    	// Extract the first 8 bits.
        var bsb = new BitStringBuilder(3);
        for (int j = 0; j < 8; j++) {
            bsb.append(itr.nextBoolean());
        }
        byte byte0 = bsb.getByteAt(0);
        if ((byte0 & 0x0ff) < 0x7f) {
        	return (char)byte0;
        } else if ((byte0 & 0x0E0) == 0x0C0) {
        	for (int j = 0; j < 8; j++) {
        		bsb.append(itr.nextBoolean());
        	}
        	byte byte1 = bsb.getByteAt(1);
        	int value = (byte0 & 0x1F) << 6;
        	value |= (byte1 & 0x3F);
        	return (char)value;
        } else {
        	for (int j = 0; j < 16; j++) {
        		bsb.append(itr.nextBoolean());
        	}
        	byte byte1 = bsb.getByteAt(1);
        	byte byte2 = bsb.getByteAt(2);
        	int value = (byte0 & 0x0F) << 12;
        	value |= (byte1 & 0x3F) << 6;
        	value |= (byte2 & 0x3F);
        	return (char) value;
        }
    }

    /**
     * Access a selected bit
     * @param i The index of the selected bit
     * @return true if the selected bit is a 1
     */
    @Override
    public boolean get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (theData[index(i)] & mask(i)) != 0;
    }

    /**
     * Return a String representation of this BitString
     * where each 1 is a '1' and each 0 is a '0'
     * @return A String representation of this BitString.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (get(i)) {
                result.append("1");
            } else {
                result.append("0");
            }
        }
        return result.toString();
    }
    
    /**
     * Create a BitString from a string of 1 and 0 chars.
     * @param s The input string
     * @return The equivalent BitString
     * @throws IllegalArgumentException if the string contains any character
     * other than 1 or 0.
     */
    public static BitString fromString(String s) {
        char[] chars = s.toCharArray();
        var bsb = new BitStringBuilder((chars.length+7)/8);
        for (char c : chars) {
            switch (c) {
                case '1':
                    bsb.append(true);
                    break;
                case '0':
                    bsb.append(false);
                    break;
                default:
                    throw new IllegalArgumentException(s + "Contains char other than 1 or 0");
            }
        }
        return bsb.toBitString();
    }

    /**
     * Determine if two bitStrings are equal
     * @param other The other BitString
     * @return true If other is a BitString with the same
     *         contents as this BitString
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof BitString) {
            BitString otherBitString =
                    (BitString) other;
            for (int i = 0; i < otherBitString.theData.length; i++) {
                if (theData[i] != otherBitString.theData[i]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * A method to append a bit to a BitString.
     * @param bit The bit to append
     * @return A new BitString with the appended bit.
     */
    public BitString append(boolean bit) {
        return new BitStringBuilder(this).append(bit).toBitString();
    }

    /**
     * A method to append one BitString onto another
     * @param left BitString
     * @param right The right BitString
     * @return The modified BitString
     */
    public static BitString append(BitString left, BitString right) {
        BitStringBuilder result = new BitStringBuilder(left);
        result.append(right);
        return result.toBitString();
    }

    /**
     * Return a hashCode for this BitString
     * @return The hashCode for this BitString
     */
    @Override
    public int hashCode() {
        int result = 0;
        for (int i = 0; i < theData.length; i++) {
            result = (result << 1) | (result >> 31);
            result ^= theData[i];
        }
        return result;
    }

    /**
     * Return the size of this BitString
     * @return The size of this BitString
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * Convert an int to an array of bytes.
     * The array is in little-endian format.
     * @param theInt The int to be converted
     * @return An array of bytes representing the int
     */
    private static byte[] toByteArray(int theInt) {
        byte[] result = new byte[4];
        for (int i = 0; i < 4; i++) {
            result[i] = (byte)(theInt & 0xFF);
            theInt >>= 8;
        }
        return result;
    }
    
    /**
     * Convert an array of bytes to an int.
     * The array is in little-endian format.
     * @param theBytes An array of 4 bytes
     * @return The equivalent int value.
     */
    private static int toInt(byte[] theBytes) {
        int result = 0;
        for (int i = 3; i >= 0; i--) {
            int byteValue = theBytes[i] & 0xFF;
            result <<= 8;
            result += byteValue;
        }
        return result;
    }
    
    /**
     * Write this BitString to an OutputStream.
     * @param out The destination stream
     */
    public void writeToStream(OutputStream out) {
        try {
            out.write(toByteArray(size), 0, 4);
            int maxNeededBytes = (size+7)/8;
            out.write(theData, 0, maxNeededBytes);
        } catch (IOException ioex) {
            throw new RuntimeException(ioex);
        }
    }
    
    /**
     * Read a BitString from an InputStream.
     * @param in The source stream
     * @return The equivalent BitString
     */
    public static BitString readFromStream(InputStream in) {
        try {
            byte[] sizeAsBytes = new byte[4];
            in.read(sizeAsBytes);
            int size = toInt(sizeAsBytes);
            int maxNumBytes = (size+7)/8;
            byte[] theData = new byte[maxNumBytes];
            in.read(theData);
            return new BitString(theData, size);
        } catch (IOException ioex) {
            throw new RuntimeException(ioex);
        }
    }
}
