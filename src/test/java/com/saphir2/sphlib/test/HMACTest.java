package com.saphir2.sphlib.test;

import com.saphir2.sphlib.BMW224;
import com.saphir2.sphlib.Digest;
import com.saphir2.sphlib.HMAC;
import com.saphir2.sphlib.MD5;
import com.saphir2.sphlib.SHA1;
import com.saphir2.sphlib.TestSupportUtils;

import org.junit.Test;

import com.saphir2.sphlib.BMW256;
import com.saphir2.sphlib.BMW384;
import com.saphir2.sphlib.BMW512;

public class HMACTest {

  @Test
  public void testHMAC() {
    Digest hmac;

		/*
         * From RFC 2104.
		 */
    hmac = new HMAC(new MD5(),
                    TestSupportUtils.strtobin("0B0B0B0B0B0B0B0B0B0B0B0B0B0B0B0B"));
    TestSupportUtils.testKat(hmac, "Hi There",
                             "9294727A3638BB1C13F48EF8158BFC9D");
    hmac = new HMAC(new MD5(), TestSupportUtils.encodeLatin1("Jefe"));
    TestSupportUtils.testKat(hmac, "what do ya want for nothing?",
                             "750C783E6AB0B503EAA86E310A5DB738");
    hmac = new HMAC(new MD5(),
                    TestSupportUtils.strtobin("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
    TestSupportUtils.testKat(hmac, "\u00DD\u00DD\u00DD\u00DD\u00DD\u00DD\u00DD"
                                   + "\u00DD\u00DD\u00DD\u00DD\u00DD\u00DD\u00DD\u00DD"
                                   + "\u00DD\u00DD\u00DD\u00DD\u00DD\u00DD\u00DD\u00DD"
                                   + "\u00DD\u00DD\u00DD\u00DD\u00DD\u00DD\u00DD\u00DD"
                                   + "\u00DD\u00DD\u00DD\u00DD\u00DD\u00DD\u00DD\u00DD"
                                   + "\u00DD\u00DD\u00DD\u00DD\u00DD\u00DD\u00DD\u00DD"
                                   + "\u00DD\u00DD\u00DD",
                             "56BE34521D144C88DBB8C733F0E8B3F6");

		/*
         * From FIPS 198a.
		 */
    hmac = new HMAC(new SHA1(),
                    TestSupportUtils.strtobin("000102030405060708090A0B0C0D0E0F101112131"
                                              + "415161718191A1B1C1D1E1F20212223242526272"
                                              + "8292A2B2C2D2E2F303132333435363738393A3B3"
                                              + "C3D3E3F"));
    TestSupportUtils.testKat(hmac, "Sample #1",
                             "4F4CA3D5D68BA7CC0A1208C9C61E9C5DA0403C0A");

    hmac = new HMAC(new SHA1(),
                    TestSupportUtils.strtobin("303132333435363738393A3B3C3D3E3F40414243"));
    TestSupportUtils.testKat(hmac, "Sample #2",
                             "0922D3405FAA3D194F82A45830737D5CC6C75D24");

    hmac = new HMAC(new SHA1(),
                    TestSupportUtils.strtobin("505152535455565758595A5B5C5D5E5F606162636"
                                              + "465666768696A6B6C6D6E6F70717273747576777"
                                              + "8797A7B7C7D7E7F808182838485868788898A8B8"
                                              + "C8D8E8F909192939495969798999A9B9C9D9E9FA"
                                              + "0A1A2A3A4A5A6A7A8A9AAABACADAEAFB0B1B2B3"));
    TestSupportUtils.testKat(hmac, "Sample #3",
                             "BCF41EAB8BB2D802F3D05CAF7CB092ECF8D1A3AA");

    hmac = new HMAC(new SHA1(),
                    TestSupportUtils.strtobin("707172737475767778797A7B7C7D7E7F808182838"
                                              + "485868788898A8B8C8D8E8F90919293949596979"
                                              + "8999A9B9C9D9E9FA0"), 12);
    TestSupportUtils.testKat(hmac, "Sample #4",
                             "9EA886EFE268DBECCE420C75");

		/*
                 * From Blue Midnight Wish specification.
		 */
    hmac = new HMAC(new BMW224(),
                    TestSupportUtils.strtobin(
                        "000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F202122232425262728292A2B2C2D2E2F303132333435363738393A3B3C3D3E3F"));
    TestSupportUtils
        .testKat(hmac, "Sample #1", "A208BC287D297A967C12801F12302EB7FB5511DE357D5B5677D8C050");
    hmac = new HMAC(new BMW224(),
                    TestSupportUtils.strtobin("303132333435363738393A3B3C3D3E3F40414243"));
    TestSupportUtils
        .testKat(hmac, "Sample #2", "525E551A5B890B00A7A99E27FF8C99AC6CD77E89E3B803007710DF4B");
    hmac = new HMAC(new BMW224(),
                    TestSupportUtils.strtobin(
                        "505152535455565758595A5B5C5D5E5F606162636465666768696A6B6C6D6E6F707172737475767778797A7B7C7D7E7F808182838485868788898A8B8C8D8E8F909192939495969798999A9B9C9D9E9FA0A1A2A3A4A5A6A7A8A9AAABACADAEAFB0B1B2B3"));
    TestSupportUtils.testKat(hmac,
                             "The successful verification of a MAC does not completely guarantee that the accompanying message is authentic.",
                             "D1674B83B37830E6AF7DBCC6260E3DECB8BB23F56DDA2CA828C60B87");
    hmac = new HMAC(new BMW224(),
                    TestSupportUtils.strtobin(
                        "505152535455565758595A5B5C5D5E5F606162636465666768696A6B6C6D6E6F707172737475767778797A7B7C7D7E7F808182838485868788898A8B8C8D8E8F909192939495969798999A9B9C9D9E9FA0A1A2A3A4A5A6A7A8A9AAABACADAEAFB0B1B2B3"));
    TestSupportUtils.testKat(hmac,
                             "The successful verification of a MAC does not completely guarantee that the accompanying message is authentic: there is a chance that a source with no knowledge of the key can present a purported MAC.",
                             "16F9D79EF410A118DDD398396A6A3FD0AC9816ED7110ECA90A05430A");

    hmac = new HMAC(new BMW256(),
                    TestSupportUtils.strtobin(
                        "000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F202122232425262728292A2B2C2D2E2F303132333435363738393A3B3C3D3E3F"));
    TestSupportUtils.testKat(hmac, "Sample #1",
                             "B5F059FD59189FA9B4C0C11C2B132C67D89CBAE1F116A2D2A1539344D8E2F938");
    hmac = new HMAC(new BMW256(),
                    TestSupportUtils.strtobin("303132333435363738393A3B3C3D3E3F40414243"));
    TestSupportUtils.testKat(hmac, "Sample #2",
                             "7B203B5415EEF50E6E64C1C758BD06D0ED23D9931F74F713D49BD07583251FFE");
    hmac = new HMAC(new BMW256(),
                    TestSupportUtils.strtobin(
                        "505152535455565758595A5B5C5D5E5F606162636465666768696A6B6C6D6E6F707172737475767778797A7B7C7D7E7F808182838485868788898A8B8C8D8E8F909192939495969798999A9B9C9D9E9FA0A1A2A3A4A5A6A7A8A9AAABACADAEAFB0B1B2B3"));
    TestSupportUtils.testKat(hmac,
                             "The successful verification of a MAC does not completely guarantee that the accompanying message is authentic.",
                             "6696C4094F8D89BCEE17AF4350DC4D3E84A2E2CA1A239DE8C5B689F07FAF6248");
    hmac = new HMAC(new BMW256(),
                    TestSupportUtils.strtobin(
                        "505152535455565758595A5B5C5D5E5F606162636465666768696A6B6C6D6E6F707172737475767778797A7B7C7D7E7F808182838485868788898A8B8C8D8E8F909192939495969798999A9B9C9D9E9FA0A1A2A3A4A5A6A7A8A9AAABACADAEAFB0B1B2B3"));
    TestSupportUtils.testKat(hmac,
                             "The successful verification of a MAC does not completely guarantee that the accompanying message is authentic: there is a chance that a source with no knowledge of the key can present a purported MAC.",
                             "F5C8A1F531FD09D1F33845E705075A8CE5EEB29B33EFF70BAE97B750E3231383");

    hmac = new HMAC(new BMW384(),
                    TestSupportUtils.strtobin(
                        "000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F202122232425262728292A2B2C2D2E2F303132333435363738393A3B3C3D3E3F"));
    TestSupportUtils.testKat(hmac, "Sample #1",
                             "E7BEAC8B685724D5B625E79E007172DF97FC85DB120DF5B752E618A676860EBB73F46E70FAA0F084937BFD6A21404913");
    hmac = new HMAC(new BMW384(),
                    TestSupportUtils.strtobin("303132333435363738393A3B3C3D3E3F40414243"));
    TestSupportUtils.testKat(hmac, "Sample #2",
                             "9E7DAF3407CB1BC0CA3101F93A3D857B44815D0C7203BC66DE907C6C3DE7E322E78A9072B285C97BEED23A85521F5EE7");
    hmac = new HMAC(new BMW384(),
                    TestSupportUtils.strtobin(
                        "505152535455565758595A5B5C5D5E5F606162636465666768696A6B6C6D6E6F707172737475767778797A7B7C7D7E7F808182838485868788898A8B8C8D8E8F909192939495969798999A9B9C9D9E9FA0A1A2A3A4A5A6A7A8A9AAABACADAEAFB0B1B2B3505152535455565758595A5B5C5D5E5F606162636465666768696A6B6C6D6E6F707172737475767778797A7B7C7D7E7F808182838485868788898A8B8C8D8E8F909192939495969798999A9B9C9D9E9FA0A1A2A3A4A5A6A7A8A9AAABACADAEAFB0B1B2B3"));
    TestSupportUtils.testKat(hmac,
                             "The successful verification of a MAC does not completely guarantee that the accompanying message is authentic.",
                             "515079D15A09C721C63F3E1011DC78837D1362753377F861FF34F9E884B84EA0A60ADA03AF5FC724870CCA900EC8E3B5");
    hmac = new HMAC(new BMW384(),
                    TestSupportUtils.strtobin(
                        "505152535455565758595A5B5C5D5E5F606162636465666768696A6B6C6D6E6F707172737475767778797A7B7C7D7E7F808182838485868788898A8B8C8D8E8F909192939495969798999A9B9C9D9E9FA0A1A2A3A4A5A6A7A8A9AAABACADAEAFB0B1B2B3"));
    TestSupportUtils.testKat(hmac,
                             "The successful verification of a MAC does not completely guarantee that the accompanying message is authentic: there is a chance that a source with no knowledge of the key can present a purported MAC.",
                             "9525578E38E7DD70CB9FECB6DC72DEC0388072FD3C63F6EC733E26466DA7EEA23A5CD49C5B566D8E730E30838F4C5563");

    hmac = new HMAC(new BMW512(),
                    TestSupportUtils.strtobin(
                        "000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F202122232425262728292A2B2C2D2E2F303132333435363738393A3B3C3D3E3F"));
    TestSupportUtils.testKat(hmac, "Sample #1",
                             "7017DB5D590A803ECDD0E87818083D657BB85636ED039BAAD3185D8CAB82E0172D1957757D6E5E2F288D43E032635E8FC4B9FAA9FD445CB1161F7786D805529F");
    hmac = new HMAC(new BMW512(),
                    TestSupportUtils.strtobin("303132333435363738393A3B3C3D3E3F40414243"));
    TestSupportUtils.testKat(hmac, "Sample #2",
                             "CEF9110B1F90A24080C8CE794FD922F8669A1A0A74299DB9789D9BD9CCC8BA7E9438BD2383F14D3C9278FDB65C0A3FCFCBF2EB570C08588488F5F9AF428D8F67");
    hmac = new HMAC(new BMW512(),
                    TestSupportUtils.strtobin(
                        "505152535455565758595A5B5C5D5E5F606162636465666768696A6B6C6D6E6F707172737475767778797A7B7C7D7E7F808182838485868788898A8B8C8D8E8F909192939495969798999A9B9C9D9E9FA0A1A2A3A4A5A6A7A8A9AAABACADAEAFB0B1B2B3505152535455565758595A5B5C5D5E5F606162636465666768696A6B6C6D6E6F707172737475767778797A7B7C7D7E7F808182838485868788898A8B8C8D8E8F909192939495969798999A9B9C9D9E9FA0A1A2A3A4A5A6A7A8A9AAABACADAEAFB0B1B2B3"));
    TestSupportUtils.testKat(hmac,
                             "The successful verification of a MAC does not completely guarantee that the accompanying message is authentic.",
                             "8519939233A4547258AFB322FAABDECFBE3F99B83CD0F760944B3F9B9FC0CD2DBBA98A069CC267CA80B53D9BA6D9E89C5A02173C661E5E715902D5F5B23FEA9F");
    hmac = new HMAC(new BMW512(),
                    TestSupportUtils.strtobin(
                        "505152535455565758595A5B5C5D5E5F606162636465666768696A6B6C6D6E6F707172737475767778797A7B7C7D7E7F808182838485868788898A8B8C8D8E8F909192939495969798999A9B9C9D9E9FA0A1A2A3A4A5A6A7A8A9AAABACADAEAFB0B1B2B3"));
    TestSupportUtils.testKat(hmac,
                             "The successful verification of a MAC does not completely guarantee that the accompanying message is authentic: there is a chance that a source with no knowledge of the key can present a purported MAC.",
                             "44FCDF6C712B75BE3CA93EB2F98ECEAB23D7C5A3839C2D267CFE0A9A202E73756B8B30882D94725A82D2C705B5256154231EC14756CCF4A7132E911CA24C1AAB");

    TestSupportUtils.reportSuccess("HMAC");
  }
}
