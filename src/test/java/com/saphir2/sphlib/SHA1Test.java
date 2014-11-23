package com.saphir2.sphlib;

import org.junit.Test;

public class SHA1Test extends AlgorithmTest {

  @Test
  public void testSHA1() {
    Digest dig = new SHA1();
    testDigestHexSource(dig, "abc", "a9993e364706816aba3e25717850c26c9cd0d89d");
    testDigestHexSource(dig, "abcdbcdecdefdefgefghfghighijhijkijkljklmklmnlmnomnopnopq",
                        "84983e441c3bd26ebaae4aa1f95129e5e54670f1");
    testDigestMillionA(dig, "34aa973cd4c4daa4f61eeb2bdbad27316534016f");
  }
}
