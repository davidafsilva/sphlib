package com.saphir2.sphlib.test;

import com.saphir2.sphlib.Digest;
import com.saphir2.sphlib.TestSupportUtils;
import com.saphir2.sphlib.Whirlpool;
import com.saphir2.sphlib.Whirlpool1;

import org.junit.Test;

import com.saphir2.sphlib.Whirlpool0;

public class WhirlpoolTest {

  @Test
  public void testWhirlpool() {
    Digest dig = new Whirlpool();
    Digest dig0 = new Whirlpool0();
    Digest dig1 = new Whirlpool1();

    TestSupportUtils.testKat(dig, "",
                             "19FA61D75522A4669B44E39C1D2E1726C530232130D407F89AFEE0964997F7A7"
                             + "3E83BE698B288FEBCF88E3E03C4F0757EA8964E59B63D93708B138CC42A66EB3");
    TestSupportUtils.testKat(dig, "a",
                             "8ACA2602792AEC6F11A67206531FB7D7F0DFF59413145E6973C45001D0087B42"
                             + "D11BC645413AEFF63A42391A39145A591A92200D560195E53B478584FDAE231A");
    TestSupportUtils.testKat(dig, "abc",
                             "4E2448A4C6F486BB16B6562C73B4020BF3043E3A731BCE721AE1B303D97E6D4C"
                             + "7181EEBDB6C57E277D0E34957114CBD6C797FC9D95D8B582D225292076D4EEF5");
    TestSupportUtils.testKat(dig, "message digest",
                             "378C84A4126E2DC6E56DCC7458377AAC838D00032230F53CE1F5700C0FFB4D3B"
                             + "8421557659EF55C106B4B52AC5A4AAA692ED920052838F3362E86DBD37A8903E");
    TestSupportUtils.testKat(dig, "abcdefghijklmnopqrstuvwxyz",
                             "F1D754662636FFE92C82EBB9212A484A8D38631EAD4238F5442EE13B8054E41B"
                             + "08BF2A9251C30B6A0B8AAE86177AB4A6F68F673E7207865D5D9819A3DBA4EB3B");
    TestSupportUtils.testKat(dig, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                  + "abcdefghijklmnopqrstuvwxyz0123456789",
                             "DC37E008CF9EE69BF11F00ED9ABA26901DD7C28CDEC066CC6AF42E40F82F3A1E"
                             + "08EBA26629129D8FB7CB57211B9281A65517CC879D7B962142C65F5A7AF01467");
    TestSupportUtils.testKat(dig, "123456789012345678901234567890"
                                  + "12345678901234567890123456789012345678901234567890",
                             "466EF18BABB0154D25B9D38A6414F5C08784372BCCB204D6549C4AFADB601429"
                             + "4D5BD8DF2A6C44E538CD047B2681A51A2C60481E88C5A20B2C2A80CF3A9A083B");
    TestSupportUtils.testKat(dig, "abcdbcdecdefdefgefghfghighijhijk",
                             "2A987EA40F917061F5D6F0A0E4644F488A7A5A52DEEE656207C562F988E95C69"
                             + "16BDC8031BC5BE1B7B947639FE050B56939BAAA0ADFF9AE6745B7B181C3BE3FD");

    TestSupportUtils.testKatMillionA(dig,
                                     "0C99005BEB57EFF50A7CF005560DDF5D29057FD86B20BFD62DECA0F1CCEA4AF5"
                                     + "1FC15490EDDC47AF32BB2B66C34FF9AD8C6008AD677F77126953B226E4ED8B01");

    TestSupportUtils.testKat(dig0, "",
                             "B3E1AB6EAF640A34F784593F2074416ACCD3B8E62C620175FCA0997B1BA23473"
                             + "39AA0D79E754C308209EA36811DFA40C1C32F1A2B9004725D987D3635165D3C8");
    TestSupportUtils.testKat(dig0, "The quick brown fox jumps over the lazy dog",
                             "4F8F5CB531E3D49A61CF417CD133792CCFA501FD8DA53EE368FED20E5FE0248C"
                             + "3A0B64F98A6533CEE1DA614C3A8DDEC791FF05FEE6D971D57C1348320F4EB42D");
    TestSupportUtils.testKat(dig0, "The quick brown fox jumps over the lazy eog",
                             "228FBF76B2A93469D4B25929836A12B7D7F2A0803E43DABA0C7FC38BC11C8F2A"
                             + "9416BBCF8AB8392EB2AB7BCB565A64AC50C26179164B26084A253CAF2E012676");

    TestSupportUtils.testKat(dig1, "",
                             "470F0409ABAA446E49667D4EBE12A14387CEDBD10DD17B8243CAD550A089DC0F"
                             + "EEA7AA40F6C2AAAB71C6EBD076E43C7CFCA0AD32567897DCB5969861049A0F5A");
    TestSupportUtils.testKat(dig1, "The quick brown fox jumps over the lazy dog",
                             "3CCF8252D8BBB258460D9AA999C06EE38E67CB546CFFCF48E91F700F6FC7C183"
                             + "AC8CC3D3096DD30A35B01F4620A1E3A20D79CD5168544D9E1B7CDF49970E87F1");
    TestSupportUtils.testKat(dig1, "The quick brown fox jumps over the lazy eog",
                             "C8C15D2A0E0DE6E6885E8A7D9B8A9139746DA299AD50158F5FA9EECDDEF744F9"
                             + "1B8B83C617080D77CB4247B1E964C2959C507AB2DB0F1F3BF3E3B299CA00CAE3");

    TestSupportUtils.reportSuccess("Whirlpool");
  }
}
