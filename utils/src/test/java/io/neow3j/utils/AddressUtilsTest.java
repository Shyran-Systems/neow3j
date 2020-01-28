package io.neow3j.utils;

import static junit.framework.TestCase.fail;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import io.neow3j.crypto.Hash;
import org.junit.Test;

public class AddressUtilsTest {

    @Test
    public void scriptHashToAddress() {
        String script =
                "2102208aea0068c429a03316e37be0e3e8e21e6cda5442df4c5914a19b3a9b6de37568747476aa";
        byte[] scriptHash = Hash.sha256AndThenRipemd160(Numeric.hexStringToByteArray(script));
        String address = AddressUtils.scriptHashToAddress(scriptHash);
        String expectedAddress = "Aa63RMYRWHPRcrZNzUnq5SNrPqoV866Spu";
        assertThat(address, is(expectedAddress));
    }

    @Test
    public void addressToScriptHash() {
        byte[] scriptHash = AddressUtils.addressToScriptHash("Aa63RMYRWHPRcrZNzUnq5SNrPqoV866Spu");
        String script =
                "2102208aea0068c429a03316e37be0e3e8e21e6cda5442df4c5914a19b3a9b6de37568747476aa";
        byte[] expected = Hash.sha256AndThenRipemd160(Numeric.hexStringToByteArray(script));
        assertArrayEquals(scriptHash, expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToScriptHashLargerThan25Chars() {
        AddressUtils.addressToScriptHash("AK2nJJpJr6o664CWJKi1QRXjqeic2zRp8yyyy");
    }

    @Test
    public void testScriptHashToAddress() {
        byte[] script = Numeric.hexStringToByteArray("d336d7eb9975a29b2404fdb28185e277a4b299bc");
        String address = "Ab2fvZdmnM4HwDgVbdBrbTLz1wK5TcEyhU";

        assertThat(AddressUtils.scriptHashToAddress(script), is(address));
    }

    @Test
    public void testIsValidAddress() {
        assertTrue(AddressUtils.isValidAddress("Ab2fvZdmnM4HwDgVbdBrbTLz1wK5TcEyhU"));
        assertTrue(AddressUtils.isValidAddress("AK2nJJpJr6o664CWJKi1QRXjqeic2zRp8y"));

        assertFalse(AddressUtils.isValidAddress(""));
        assertFalse(AddressUtils.isValidAddress("0"));
        assertFalse(AddressUtils.isValidAddress("b2fvZdmnM4HwDgVbdBrbTLz1wK5TcEyhU"));
        assertFalse(AddressUtils.isValidAddress("AAb2fvZdmnM4HwDgVbdBrbTLz1wK5TcEyhU"));

        // If the address string is null, we don't want to say it is an invalid address because
        // there isn't even an address to be deemed invalid. Therefore expect NullPointerException.
        try {
            AddressUtils.isValidAddress(null);
        } catch (NullPointerException e) {
            return;
        }
        fail();
    }
}