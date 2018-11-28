package oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.exeptions;

public class UserNotRegistred extends Exception {

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage()+" The  server is not saved into the remote database";
    }
}
