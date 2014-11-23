package com.saphir2.sphlib.test;

import com.saphir2.sphlib.Digest;
import com.saphir2.sphlib.SHA1;
import com.saphir2.sphlib.TestSupportUtils;

import org.junit.Test;

public class SHA1Test {

  @Test
  public void testSHA1() {
    Digest dig = new SHA1();
    TestSupportUtils.testKat(dig, "abc", "a9993e364706816aba3e25717850c26c9cd0d89d");
    TestSupportUtils.testKat(dig, "abcdbcdecdefdefgefghfghighijhijkijkljklmklmnlm"
                                  + "nomnopnopq",
                             "84983e441c3bd26ebaae4aa1f95129e5e54670f1");

    TestSupportUtils.testKatMillionA(dig,
                                     "34aa973cd4c4daa4f61eeb2bdbad27316534016f");

    TestSupportUtils.reportSuccess("SHA-1");
  }
}
