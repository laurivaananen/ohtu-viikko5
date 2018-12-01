package ohtu;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private List<String> scores = Arrays.asList("Love", "Fifteen", "Thirty", "Forty");
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    private String even() {
        String score = "";
        try {
            score += scores.get(m_score1);
            score += "-All";
        } catch (IndexOutOfBoundsException exception) {
            score += "Deuce";
        }
        return score;
    }

    private String lead(int tempScore) {
        String score = "";
        score += scores.get(tempScore);
        return score;
    }

    public String getScore() {
        String score = "";
        if (m_score1==m_score2) {
            score = even();
        } else if (m_score1>=4 || m_score2>=4) {
            int minusResult = m_score1-m_score2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        } else {
            score += lead(m_score1);
            score += "-";
            score += lead(m_score2);
        }
        return score;
    }
}
