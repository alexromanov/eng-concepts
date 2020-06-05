package alexromanov.engconcepts.hackerrank;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WarmUpChallengesTest {
    @Test
    public void shouldCountNumberOfSocks(){
        int numberOfSocks = 9;
        int[] socks = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        assertThat(WarmUpChallenges.sockMerchant(numberOfSocks, socks)).isEqualTo(3);
    }

    @Test
    public void shouldCountRepeatedString(){
        String s = "aba";
        long n = 10;
        assertThat(WarmUpChallenges.repeatedString(s, n)).isEqualTo(7);
    }

    @Test
    public void shouldCountRepeatedStringForSingleCharacter(){
        String s = "a";
        long n = 1000000000000L;
        assertThat(WarmUpChallenges.repeatedString(s, n)).isEqualTo(1000000000000L);
    }
}
