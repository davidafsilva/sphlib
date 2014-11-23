package com.saphir2.sphlib.test;

import com.saphir2.sphlib.Digest;
import com.saphir2.sphlib.TestSupportUtils;

import org.junit.Test;

import com.saphir2.sphlib.Tiger2;

public class Tiger2Test {

  @Test
  public void testTiger2() {
    Digest dig = new Tiger2();
    TestSupportUtils.testKat(dig, "",
                             "4441BE75F6018773C206C22745374B924AA8313FEF919F41");
    TestSupportUtils.testKat(dig, "a",
                             "67E6AE8E9E968999F70A23E72AEAA9251CBC7C78A7916636");
    TestSupportUtils.testKat(dig, "abc",
                             "F68D7BC5AF4B43A06E048D7829560D4A9415658BB0B1F3BF");
    TestSupportUtils.testKat(dig, "message digest",
                             "E29419A1B5FA259DE8005E7DE75078EA81A542EF2552462D");
    TestSupportUtils.testKat(dig, "abcdefghijklmnopqrstuvwxyz",
                             "F5B6B6A78C405C8547E91CD8624CB8BE83FC804A474488FD");
    TestSupportUtils.testKat(dig, "abcdbcdecdefdefgefghfghighijhijkijkljklmklmn"
                                  + "lmnomnopnopq",
                             "A6737F3997E8FBB63D20D2DF88F86376B5FE2D5CE36646A9");
    TestSupportUtils.testKat(dig, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                  + "abcdefghijklmnopqrstuvwxyz0123456789",
                             "EA9AB6228CEE7B51B77544FCA6066C8CBB5BBAE6319505CD");
    TestSupportUtils.testKat(dig, "1234567890123456789012345678901234567890"
                                  + "1234567890123456789012345678901234567890",
                             "D85278115329EBAA0EEC85ECDC5396FDA8AA3A5820942FFF");

    TestSupportUtils.testKatMillionA(dig,
                                     "E068281F060F551628CC5715B9D0226796914D45F7717CF4");

    TestSupportUtils.reportSuccess("Tiger2");
  }
}
