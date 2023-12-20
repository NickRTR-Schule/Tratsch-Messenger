package gemeinsam;

@SuppressWarnings("serial")
public class ServerBotschaftLoginNOK extends Botschaft
{
	private String meldung;
	
	public ServerBotschaftLoginNOK(String pMeldung)
	{
		meldung = pMeldung;
	}
	
	public String liesMeldung()
	{
		return meldung;
	}
}
