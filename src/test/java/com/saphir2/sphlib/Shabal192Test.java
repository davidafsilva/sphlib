package com.saphir2.sphlib;

import org.junit.Test;

public class Shabal192Test extends AlgorithmTest {

  @Test
  public void testShabal192() {
    testDigestHexSource(new Shabal192(),
                        "abcdefghijklmnopqrstuvwxyz-0123456789-ABCDEFGHIJKLM"
                        + "NOPQRSTUVWXYZ-0123456789-abcdefghijklmnopqrstuvwxyz",
                        "690FAE79226D95760AE8FDB4F58C0537111756557D307B15");
  }
}
