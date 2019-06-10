package various;

public enum Sport {

    VTT,
    KITE,
    TRI,
    SURF;

    public static Sport getSport(Character ch) {

        switch (ch) {
            case 'V': return VTT;
            case 'K': return KITE;
            case 'T': return TRI;
            case 'S': return SURF;
        }

        return null;
    }
}
