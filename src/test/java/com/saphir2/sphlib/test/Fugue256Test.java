package com.saphir2.sphlib.test;

import com.saphir2.sphlib.TestSupportUtils;

import org.junit.Test;

import com.saphir2.sphlib.Fugue256;

public class Fugue256Test {

  @Test
  public void testFugue256() {
    TestSupportUtils.testKatHex(new Fugue256(),
                                "",
                                "d6ec528980c130aad1d1acd28b9dd8dbdeae0d79eded1fca72c2af9f37c2246f");
    TestSupportUtils.testKatHex(new Fugue256(),
                                "cc",
                                "b894eb2df58162f6c48d495f156e73bd086dd13db407ee38781177bb23d129bb");
    TestSupportUtils.testKatHex(new Fugue256(),
                                "41fb",
                                "584827dea879a043438c23a32c42ba0990f0f8ce385852693b7eeb2bc4d7fab1");
    TestSupportUtils.testKatHex(new Fugue256(),
                                "1f877c",
                                "f9f5cf602b093c43bf9c6d551f6a9e60214ce1bb3a6d842c3d9a5f358df05547");
    TestSupportUtils.testKatHex(new Fugue256(),
                                "c1ecfdfc",
                                "9041d9edf413cf0a8cfb6aed97c13032315319438be004685f4bb583f67acf23");
    TestSupportUtils.testKatHex(new Fugue256(),
                                "21f134ac57",
                                "2fca43424b89301d8e1ba3c5eb760a8633639b35c5d72331c0a26ed4aee7e4ba");
    TestSupportUtils.testKatHex(new Fugue256(),
                                "c6f50bb74e29",
                                "70d683f0b39d3016fc243355a2e40a7f1337aa826fc88785a3f15c0d5e96eb1c");
    TestSupportUtils.testKatHex(new Fugue256(),
                                "119713cc83eeef",
                                "5fb6e8b104bd05ff4b4606a5dbc204b1996ceac8721a0f988596ceb6ca38e431");
    TestSupportUtils.testKatHex(new Fugue256(),
                                "4a4f202484512526",
                                "84e8df742af4ab3f552a148485a1d27943b57ba748b76a1cdf8e1f054bed3d7b");
    TestSupportUtils.testKatHex(new Fugue256(),
                                "1f66ab4185ed9b6375",
                                "0f0e687507e64d63234cc50e627dd1a0a51c6c06ad45fb32604c5921e37daa2a");
    TestSupportUtils.testKatHex(new Fugue256(),
                                "eed7422227613b6f53c9",
                                "3cfb02bd515e9d983cc1665ad9368f77c89fee97eb574bf7db8c3d8e44396fb9");
    TestSupportUtils.testKatHex(new Fugue256(),
                                "eaeed5cdffd89dece455f1",
                                "2cf0a9ba776998481c86cc66ae958942cc2e0ccc72b4094d8628731c0a9366b8");
    TestSupportUtils.testKatHex(new Fugue256(),
                                "5be43c90f22902e4fe8ed2d3",
                                "d94c33e8312522b6393ebdfb4c99137265c8965782e4d7b4495640bfd6a75760");
    TestSupportUtils.testKatHex(new Fugue256(),
                                "a746273228122f381c3b46e4f1",
                                "6fcedcfd9d830702c0e4efcbb19a305449f402a6e7f02bf4236c8bae69f28b31");
    TestSupportUtils.testKatHex(new Fugue256(),
                                "3c5871cd619c69a63b540eb5a625",
                                "140bb7182339669ea91422ef67f332c7048d5e4a14875b3fda16d2ec5432dc46");
    TestSupportUtils.testKatHex(new Fugue256(),
                                "fa22874bcc068879e8ef11a69f0722",
                                "af6e59a0291236d31c8ed4e05dd121125dcd9b70411dfa9d2e2be7423ed2d358");
    TestSupportUtils.testKatHex(new Fugue256(),
                                "52a608ab21ccdd8a4457a57ede782176",
                                "3260f5be7147be7db0aefa571bf0fef651bbcb1796513572ee66855492e893d7");
    TestSupportUtils.reportSuccess("Fugue-256");
  }
}
