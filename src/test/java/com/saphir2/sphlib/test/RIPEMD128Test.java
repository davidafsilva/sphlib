package com.saphir2.sphlib.test;

import com.saphir2.sphlib.Digest;
import com.saphir2.sphlib.TestSupportUtils;

import org.junit.Test;

import com.saphir2.sphlib.RIPEMD128;

public class RIPEMD128Test {

  @Test
  public void testRIPEMD128() {
    Digest dig = new RIPEMD128();
    TestSupportUtils.testKat(dig, "",
                             "cdf26213a150dc3ecb610f18f6b38b46");
    TestSupportUtils.testKat(dig, "a",
                             "86be7afa339d0fc7cfc785e72f578d33");
    TestSupportUtils.testKat(dig, "abc",
                             "c14a12199c66e4ba84636b0f69144c77");
    TestSupportUtils.testKat(dig, "message digest",
                             "9e327b3d6e523062afc1132d7df9d1b8");
    TestSupportUtils.testKat(dig, "abcdefghijklmnopqrstuvwxyz",
                             "fd2aa607f71dc8f510714922b371834e");
    TestSupportUtils.testKat(dig, "abcdbcdecdefdefgefghfghighijhijkijkljklmklmn"
                                  + "lmnomnopnopq",
                             "a1aa0689d0fafa2ddc22e88b49133a06");
    TestSupportUtils.testKat(dig, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqr"
                                  + "stuvwxyz0123456789",
                             "d1e959eb179c911faea4624c60c5c702");
    TestSupportUtils.testKat(dig, "12345678901234567890123456789012345678901234"
                                  + "567890123456789012345678901234567890",
                             "3f45ef194732c2dbb2c4a2c769795fa3");

    TestSupportUtils.testKatMillionA(dig,
                                     "4a7f5723f954eba1216c9d8f6320431f");

    TestSupportUtils.reportSuccess("RIPEMD-128");
  }
}
