package com.saphir2.sphlib.test;

import com.saphir2.sphlib.Digest;
import com.saphir2.sphlib.RIPEMD;
import com.saphir2.sphlib.TestSupportUtils;

import org.junit.Test;

import com.saphir2.sphlib.RIPEMD128;
import com.saphir2.sphlib.RIPEMD160;

public class RIPEMDTest {

  @Test
  public void testRIPEMD() {
    Digest dig = new RIPEMD();
    TestSupportUtils.testKat(dig, "",
                             "9f73aa9b372a9dacfb86a6108852e2d9");
    TestSupportUtils.testKat(dig, "a",
                             "486f74f790bc95ef7963cd2382b4bbc9");
    TestSupportUtils.testKat(dig, "abc",
                             "3f14bad4c2f9b0ea805e5485d3d6882d");
    TestSupportUtils.testKat(dig, "message digest",
                             "5f5c7ebe1abbb3c7036482942d5f9d49");
    TestSupportUtils.testKat(dig, "abcdefghijklmnopqrstuvwxyz",
                             "ff6e1547494251a1cca6f005a6eaa2b4");
    TestSupportUtils.testKat(dig, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqr"
                                  + "stuvwxyz0123456789",
                             "ff418a5aed3763d8f2ddf88a29e62486");
    TestSupportUtils.testKat(dig, "12345678901234567890123456789012345678901234"
                                  + "567890123456789012345678901234567890",
                             "dfd6b45f60fe79bbbde87c6bfc6580a5");

    TestSupportUtils.testCollision(dig,
                                   "8eaf9f5779f5ec09ba6a4a5711354178a410b4a29f6c2fad2c"
                                   + "20560b1179754de7aade0bf291bc787d6dbc47b1d1bd9a15"
                                   + "205da4ff047181a8584726a54e0661",
                                   "8eaf9f5779f5ec09ba6a4a5711355178a410b4a29f6c2fad2c"
                                   + "20560b1179754de7aade0bf291bc787d6dc0c7b1d1bd9a15"
                                   + "205da4ff047181a8584726a54e06e1");

    TestSupportUtils.testCollision(dig,
                                   "8eaf9f5779f5ec09ba6a4a5711354178a410b4a29f6c2fad2c"
                                   + "20560b1179754de7aade0bf291bc787d6dbc47b1d1bd9a15"
                                   + "205da4ff04a5a0a8588db1b6660ce7",
                                   "8eaf9f5779f5ec09ba6a4a5711355178a410b4a29f6c2fad2c"
                                   + "20560b1179754de7aade0bf291bc787d6dc0c7b1d1bd9a15"
                                   + "205da4ff04a5a0a8588db1b6660c67");

    TestSupportUtils.reportSuccess("RIPEMD");
  }

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

  @Test
  public void testRIPEMD160() {
    Digest dig = new RIPEMD160();
    TestSupportUtils.testKat(dig, "",
                             "9c1185a5c5e9fc54612808977ee8f548b2258d31");
    TestSupportUtils.testKat(dig, "a",
                             "0bdc9d2d256b3ee9daae347be6f4dc835a467ffe");
    TestSupportUtils.testKat(dig, "abc",
                             "8eb208f7e05d987a9b044a8e98c6b087f15a0bfc");
    TestSupportUtils.testKat(dig, "message digest",
                             "5d0689ef49d2fae572b881b123a85ffa21595f36");
    TestSupportUtils.testKat(dig, "abcdefghijklmnopqrstuvwxyz",
                             "f71c27109c692c1b56bbdceb5b9d2865b3708dbc");
    TestSupportUtils.testKat(dig, "abcdbcdecdefdefgefghfghighijhijkijkljklmklmn"
                                  + "lmnomnopnopq",
                             "12a053384a9c0c88e405a06c27dcf49ada62eb2b");
    TestSupportUtils.testKat(dig, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqr"
                                  + "stuvwxyz0123456789",
                             "b0e20b6e3116640286ed3a87a5713079b21f5189");
    TestSupportUtils.testKat(dig, "12345678901234567890123456789012345678901234"
                                  + "567890123456789012345678901234567890",
                             "9b752e45573d4b39f4dbd3323cab82bf63326bfb");

    TestSupportUtils.testKatMillionA(dig,
                                     "52783243c1697bdbe16d37f97f68f08325dc1528");

    TestSupportUtils.reportSuccess("RIPEMD-160");
  }
}
