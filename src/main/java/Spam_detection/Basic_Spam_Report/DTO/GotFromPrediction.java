package Spam_detection.Basic_Spam_Report.DTO;

public class GotFromPrediction {
    public GotFromPrediction() {
    }

    @Override
    public String toString() {
        return "GotFromPrediction{" +
                "label='" + label + '\'' +
                ", prediction=" + prediction +
                '}';
    }

    String label;
    Float prediction;

    public GotFromPrediction(String label, Float prediction) {
        this.label = label;
        this.prediction = prediction;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Float getPrediction() {
        return prediction;
    }

    public void setPrediction(Float prediction) {
        this.prediction = prediction;
    }
}
