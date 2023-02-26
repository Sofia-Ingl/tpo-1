package task3;

public abstract class AnimateObject extends TranslocatableObject {

    final int maxSuffocationLevel = Integer.MAX_VALUE;
    int suffocationLevel = 0;
    boolean isDead = false;
    DeathCause deathCause = DeathCause.NONE;

    public void setSuffocation(int suffocation) {
        if (!isDead) {
            suffocationLevel = suffocation;
            tryDie();
        }
    }

    protected void tryDie() {
        if (!isDead && suffocationLevel == maxSuffocationLevel) {
            isDead = true;
            deathCause = DeathCause.SUFFOCATION;
        }
    }

}
