package algorithm.game.move.seal;

public enum Signature {
    SEAL(true), UNSEAL(false);
    boolean sealed;

    Signature(boolean sealed) {
        this.sealed = sealed;
    }

    public boolean isSealed() {
        return sealed;
    }
}
