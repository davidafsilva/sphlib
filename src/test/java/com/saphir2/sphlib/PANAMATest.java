package com.saphir2.sphlib;

import org.junit.Test;

public class PANAMATest extends AlgorithmTest {

  @Test
  public void testPANAMA() {
    Digest dig = new PANAMA();
    testDigestHexSource(dig, "",
                        "aa0cc954d757d7ac7779ca3342334ca471abd47d5952ac91ed837ecd5b16922b");
    testDigestHexSource(dig, "T",
                        "049d698307d8541f22870dfa0a551099d3d02bc6d57c610a06a4585ed8d35ff8");
    testDigestHexSource(dig, "The quick brown fox jumps over the lazy dog",
                        "5f5ca355b90ac622b0aa7e654ef5f27e9e75111415b48b8afe3add1c6b89cba1");

    testDigestMillionA(dig,
                       "af9c66fb6058e2232a5dfba063ee14b0f86f0e334e165812559435464dd9bb60");

  }
}
