package com.saphir2.sphlib;

import org.junit.Test;

public class SHA224Test extends AlgorithmTest {

  @Test
  public void testSHA224() {
    Digest dig = new SHA224();
    testDigestHexSource(dig, "abc",
                        "23097d223405d8228642a477bda255b32aadbce4bda0b3f7e36c9da7");
    testDigestHexSource(dig, "abcdbcdecdefdefgefghfghighijhijkijkljklmklmnlm"
                             + "nomnopnopq",
                        "75388b16512776cc5dba5da1fd890150b0c6455cb4f58b1952522525");

    testDigestMillionA(dig,
                       "20794655980c91d8bbb4c1ea97618a4bf03f42581948b2ee4ee7ad67");

  }
}
