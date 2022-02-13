package algorithm.errormessage;

  class FatalErrorMessage extends BaseErrorMessage {

    @Override
    public void showMessage(String error) {
        InterruptProcess.killProcess(error);
    }

}
