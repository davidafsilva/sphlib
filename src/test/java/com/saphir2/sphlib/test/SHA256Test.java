package com.saphir2.sphlib.test;

import com.saphir2.sphlib.Digest;
import com.saphir2.sphlib.TestSupportUtils;

import org.junit.Test;

import com.saphir2.sphlib.SHA256;

public class SHA256Test {

  @Test
  public void testSHA256() {
    Digest dig = new SHA256();
    TestSupportUtils.testKat(dig, "abc",
                             "ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad");
    TestSupportUtils.testKat(dig, "abcdbcdecdefdefgefghfghighijhijkijkljklmklmnlm"
                                  + "nomnopnopq",
                             "248d6a61d20638b8e5c026930c3e6039a33ce45964ff2167f6ecedd419db06c1");

    TestSupportUtils.testKatMillionA(dig,
                                     "cdc76e5c9914fb9281a1c7e284d73e67f1809a48a497200e046d39ccc7112cd0");

    TestSupportUtils.reportSuccess("SHA-256");
  }
}
