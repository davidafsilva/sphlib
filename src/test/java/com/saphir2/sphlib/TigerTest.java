package com.saphir2.sphlib;

import org.junit.Test;

public class TigerTest extends AlgorithmTest {

  @Test
  public void testTiger() {
    Digest dig = new Tiger();
    testDigestHexSource(dig, "",
                        "3293AC630C13F0245F92BBB1766E16167A4E58492DDE73F3");
    testDigestHexSource(dig, "a",
                        "77BEFBEF2E7EF8AB2EC8F93BF587A7FC613E247F5F247809");
    testDigestHexSource(dig, "abc",
                        "2AAB1484E8C158F2BFB8C5FF41B57A525129131C957B5F93");
    testDigestHexSource(dig, "message digest",
                        "D981F8CB78201A950DCF3048751E441C517FCA1AA55A29F6");
    testDigestHexSource(dig, "abcdefghijklmnopqrstuvwxyz",
                        "1714A472EEE57D30040412BFCC55032A0B11602FF37BEEE9");
    testDigestHexSource(dig, "abcdbcdecdefdefgefghfghighijhijkijkljklmklmn"
                             + "lmnomnopnopq",
                        "0F7BF9A19B9C58F2B7610DF7E84F0AC3A71C631E7B53F78E");
    testDigestHexSource(dig, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                             + "abcdefghijklmnopqrstuvwxyz0123456789",
                        "8DCEA680A17583EE502BA38A3C368651890FFBCCDC49A8CC");
    testDigestHexSource(dig, "1234567890123456789012345678901234567890"
                             + "1234567890123456789012345678901234567890",
                        "1C14795529FD9F207A958F84C52F11E887FA0CABDFD91BFD");

    testDigestMillionA(dig,
                       "6DB0E2729CBEAD93D715C6A7D36302E9B3CEE0D2BC314B41");

  }
}
