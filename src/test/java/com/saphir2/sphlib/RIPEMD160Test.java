package com.saphir2.sphlib;

import org.junit.Test;

public class RIPEMD160Test extends AlgorithmTest {

  @Test
  public void testRIPEMD160() {
    Digest dig = new RIPEMD160();
    testDigestHexSource(dig, "",
                        "9c1185a5c5e9fc54612808977ee8f548b2258d31");
    testDigestHexSource(dig, "a",
                        "0bdc9d2d256b3ee9daae347be6f4dc835a467ffe");
    testDigestHexSource(dig, "abc",
                        "8eb208f7e05d987a9b044a8e98c6b087f15a0bfc");
    testDigestHexSource(dig, "message digest",
                        "5d0689ef49d2fae572b881b123a85ffa21595f36");
    testDigestHexSource(dig, "abcdefghijklmnopqrstuvwxyz",
                        "f71c27109c692c1b56bbdceb5b9d2865b3708dbc");
    testDigestHexSource(dig, "abcdbcdecdefdefgefghfghighijhijkijkljklmklmn"
                             + "lmnomnopnopq",
                        "12a053384a9c0c88e405a06c27dcf49ada62eb2b");
    testDigestHexSource(dig, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqr"
                             + "stuvwxyz0123456789",
                        "b0e20b6e3116640286ed3a87a5713079b21f5189");
    testDigestHexSource(dig, "12345678901234567890123456789012345678901234"
                             + "567890123456789012345678901234567890",
                        "9b752e45573d4b39f4dbd3323cab82bf63326bfb");

    testDigestMillionA(dig,
                       "52783243c1697bdbe16d37f97f68f08325dc1528");

  }
}
