package com.saphir2.sphlib.test;

import com.saphir2.sphlib.Digest;
import com.saphir2.sphlib.TestSupportUtils;

import org.junit.Test;

import com.saphir2.sphlib.MD2;

public class MD2Test {

  @Test
  public void testMD2() {
    Digest dig = new MD2();
    TestSupportUtils.testKat(dig, "", "8350e5a3e24c153df2275c9f80692773");
    TestSupportUtils.testKat(dig, "a", "32ec01ec4a6dac72c0ab96fb34c0b5d1");
    TestSupportUtils.testKat(dig, "abc", "da853b0d3f88d99b30283a69e6ded6bb");
    TestSupportUtils.testKat(dig, "message digest",
                             "ab4f496bfb2a530b219ff33031fe06b0");
    TestSupportUtils.testKat(dig, "abcdefghijklmnopqrstuvwxyz",
                             "4e8ddff3650292ab5a4108c3aa47940b");
    TestSupportUtils.testKat(dig, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstu"
                                  + "vwxyz0123456789",
                             "da33def2a42df13975352846c30338cd");
    TestSupportUtils.testKat(dig, "1234567890123456789012345678901234567890123456789"
                                  + "0123456789012345678901234567890",
                             "d5976f79d83d3a0dc9806c3c66f3efd8");

    TestSupportUtils.testKatMillionA(dig, "8c0a09ff1216ecaf95c8130953c62efd");

    TestSupportUtils.reportSuccess("MD2");
  }
}
