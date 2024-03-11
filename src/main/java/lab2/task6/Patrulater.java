package lab2.task6;

class Patrulater {
    public int latura1, latura2, latura3, latura4;
    public double unghi1, unghi2, unghi3, unghi4;

    public Patrulater() {
        this(0, 0, 0, 0);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4) {
        this.latura1 = latura1;
        this.latura2 = latura2;
        this.latura3 = latura3;
        this.latura4 = latura4;
    }

    public Patrulater(double unghi1, double unghi2, double unghi3, double unghi4) {
        this(0, 0, 0, 0, unghi1, unghi2, unghi3, unghi4);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4,
                      double unghi1, double unghi2, double unghi3, double unghi4) {
        this(latura1, latura2, latura3, latura4);
        this.unghi1 = unghi1;
        this.unghi2 = unghi2;
        this.unghi3 = unghi3;
        this.unghi4 = unghi4;
    }

    public int perimetru() {
        int result;
        result = latura1 + latura2 + latura3 + latura4;
        return result;
    }
}

class Paralelogram extends Patrulater {
    public Paralelogram(int latura1, int latura2, double unghi1) {
        super(latura1, latura2, latura1, latura2, unghi1, 180 - unghi1, unghi1, 180 - unghi1);
    }

    public double Aria(){
        return latura1*latura2*Math.sin(Math.toRadians(unghi1));
    }
}

class Romb extends Paralelogram{
    private double diag1;
    private double diag2;
    public Romb(int latura1, double unghi1, double diag1, double diag2){
        super(latura1, latura1, unghi1);
        this.diag1 = diag1;
        this.diag2 = diag2;
    }

    public double Aria(){
        return (diag1*diag2)/2;
    }
}

class Dreptunghi extends Paralelogram{
    public Dreptunghi(int latura1, int latura2){
        super(latura1, latura2, 90);
    }

    public double Aria(){
        return latura1*latura2;
    }
}

class Patrat extends Dreptunghi{
    public Patrat(int latura){
        super(latura, latura);
    }
    public double Aria(){
        return latura1*latura1;
    }
}

class PatrulaterRunner {
    public static void main(String[] args) {
        Paralelogram p = new Paralelogram(2, 3, 60);
        System.out.println(p.Aria());
        Romb r = new Romb(2, 60, 3, 4);
        System.out.println(r.Aria());
        Dreptunghi d = new Dreptunghi(2, 3);
        System.out.println(d.Aria());
        Patrat p2 = new Patrat(2);
        System.out.println(p2.Aria());
    }
}