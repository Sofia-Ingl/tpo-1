package task3;

import lombok.Data;

@Data
public class MarketAnalyst extends AnimateObject {

    final int maxAstonishmentLevel = Integer.MAX_VALUE;
    int astonishmentLevel = 0;
    int heightInFt = 0;

    public MarketAnalyst(int heightInFt) {
        this.heightInFt = heightInFt;
    }

    public void setAstonishment(int astonishment) {
        if (!isDead) {
            astonishmentLevel = astonishment;
            tryDie();
        }
    }

    protected void tryDie() {
        if (!isDead && astonishmentLevel >= maxAstonishmentLevel/2 && suffocationLevel >= maxSuffocationLevel/2) {
            isDead = true;
            deathCause = DeathCause.COMBINED;
        }
        if (!isDead && astonishmentLevel == maxAstonishmentLevel) {
            isDead = true;
            deathCause = DeathCause.ASTONISHMENT;
        }
        super.tryDie();
    }

}
