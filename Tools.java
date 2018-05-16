public interface Tools<C, M>{
    public abstract double score(C customer, M movie);
    public abstract int rate(C customer, M movio) throws Exception;
    public abstract double weight(C customer1, C customer2);
}
