package com.saphir2.sphlib.test;

import com.saphir2.sphlib.Digest;
import com.saphir2.sphlib.SHA384;
import com.saphir2.sphlib.TestSupportUtils;

import org.junit.Test;

public class SHA384Test {

  @Test
  public void testSHA384() {
    Digest dig = new SHA384();
    TestSupportUtils.testKat(dig, "abc",
                             "cb00753f45a35e8bb5a03d699ac65007272c32ab0eded163"
                             + "1a8b605a43ff5bed8086072ba1e7cc2358baeca134c825a7");
    TestSupportUtils.testKat(dig, "abcdefghbcdefghicdefghijdefghijkefghijklfghij"
                                  + "klmghijklmnhijklmnoijklmnopjklmnopqklmnopqrlmnop"
                                  + "qrsmnopqrstnopqrstu",
                             "09330c33f71147e83d192fc782cd1b4753111b173b3b05d2"
                             + "2fa08086e3b0f712fcc7c71a557e2db966c3e9fa91746039");

    TestSupportUtils.testKatMillionA(dig,
                                     "9d0e1809716474cb086e834e310a4a1ced149e9c00f24852"
                                     + "7972cec5704c2a5b07b8b3dc38ecc4ebae97ddd87f3d8985");

    TestSupportUtils.reportSuccess("SHA-384");
  }
}
