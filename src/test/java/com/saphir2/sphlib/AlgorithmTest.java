/*
 * Copyright (c) 2014, David Silva
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer
 *       in the documentation and/or other materials provided with the
 *       distribution.
 *     * The names of its contributors may not be used to endorse or promote
 *       products derived from this software without specific prior written
 *       permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.saphir2.sphlib;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * The base class for all of the hashing algorithms tests
 *
 * @author David Silva
 */
abstract class AlgorithmTest {

  byte[] strToBinary(final String str) {
    int bLen = str.length() / 2;
    byte[] buf = new byte[bLen];
    for (int i = 0; i < bLen; i++) {
      String bs = str.substring(i * 2, i * 2 + 2);
      buf[i] = (byte) Integer.parseInt(bs, 16);
    }
    return buf;
  }

  void testCollision(final Digest digest, String s1, String s2) {
    try {
      final byte[] msg1 = Hex.decodeHex(s1.toCharArray());
      final byte[] msg2 = Hex.decodeHex(s2.toCharArray());
      assertFalse(Arrays.equals(msg1, msg2));
      assertTrue(Arrays.equals(digest.digest(msg1), digest.digest(msg2)));
    } catch (final DecoderException e) {
      // should not happen
      e.printStackTrace();
      fail(e.getMessage());
    }
  }

  private void testDigest(final Digest digest, final byte[] buffer, final byte[] expected) {
    // 1. test the hashing via digest().
    assertTrue(Arrays.equals(digest.digest(buffer), expected));
    digest.reset();

    // 2. test the hashing via update() + digest().
    for (final byte aBuf : buffer) {
      digest.update(aBuf);
    }
    assertTrue(Arrays.equals(digest.digest(), expected));
    digest.reset();

    // 3. test the copy/clone
    final int bLen = buffer.length;
    digest.update(0, bLen / 2, buffer);
    final Digest dig2 = digest.copy();
    digest.update(bLen / 2, bLen - (bLen / 2), buffer);
    assertTrue(Arrays.equals(digest.digest(), expected));
    dig2.update(bLen / 2, bLen - (bLen / 2), buffer);
    assertTrue(Arrays.equals(dig2.digest(), expected));
  }

  void testDigestBinSource(final Digest digest, final String data, final String expected) {
    try {
      testDigest(digest, strToBinary(data), Hex.decodeHex(expected.toCharArray()));
    } catch (final DecoderException e) {
      // should not happen
      e.printStackTrace();
      fail(e.getMessage());
    }
  }

  void testDigestHexSource(final Digest digest, final String data, final String expected) {
    try {
      testDigest(digest, data.getBytes(), Hex.decodeHex(expected.toCharArray()));
    } catch (final DecoderException e) {
      // should not happen
      e.printStackTrace();
      fail(e.getMessage());
    }
  }

  void testDigestMillionA(final Digest digest, final String expected) {
    final byte[] buf = new byte[1000];
    for (int i = 0; i < 1000; i++) {
      buf[i] = 'a';
    }
    for (int i = 0; i < 1000; i++) {
      digest.update(buf);
    }
    try {
      assertTrue(Arrays.equals(digest.digest(), Hex.decodeHex(expected.toCharArray())));
    } catch (final DecoderException e) {
      // should not happen
      e.printStackTrace();
      fail(e.getMessage());
    }
  }
}
