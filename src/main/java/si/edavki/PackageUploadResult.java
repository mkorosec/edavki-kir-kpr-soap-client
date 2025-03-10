package si.edavki;

public class PackageUploadResult {
    private boolean success;
    private boolean finished;
    private String errorMessage;
    private String resultingEdpId;

    public static PackageUploadResult success(String resultingEdpId) {
        return new PackageUploadResult(true, true, null, resultingEdpId);
    }

    public static PackageUploadResult error(String errorMessage) {
        return new PackageUploadResult(true, false, errorMessage, null);
    }

    public static PackageUploadResult pending(String resultingEdpId) {
        return new PackageUploadResult(false, false, null, resultingEdpId);
    }

    private PackageUploadResult(boolean finished, boolean success, String errorMessage, String resultingEdpId) {
        this.success = success;
        this.finished = finished;
        this.errorMessage = errorMessage;
        this.resultingEdpId = resultingEdpId;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getResultingEdpId() {
        return resultingEdpId;
    }

    public void setResultingEdpId(String resultingEdpId) {
        this.resultingEdpId = resultingEdpId;
    }
}
