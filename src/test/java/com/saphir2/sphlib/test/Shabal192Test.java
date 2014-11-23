package com.saphir2.sphlib.test;

import org.junit.Test;

import com.saphir2.sphlib.Shabal192;

import static com.saphir2.sphlib.TestSupportUtils.reportSuccess;
import static com.saphir2.sphlib.TestSupportUtils.testKat;

public class Shabal192Test {

  @Test
  public void testShabal192() {
    testKat(new Shabal192(),
            "abcdefghijklmnopqrstuvwxyz-0123456789-ABCDEFGHIJKLM"
            + "NOPQRSTUVWXYZ-0123456789-abcdefghijklmnopqrstuvwxyz",
            "690FAE79226D95760AE8FDB4F58C0537111756557D307B15");
    reportSuccess("Shabal-192");
  }
}
