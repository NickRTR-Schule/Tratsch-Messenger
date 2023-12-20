package gemeinsam;

@SuppressWarnings("serial")
public class ServerBotschaftSendenTextnachrichtNOK extends Botschaft
{
	private String meldung;
	
	public ServerBotschaftSendenTextnachrichtNOK(String pMeldung)
	{
		meldung = pMeldung;
	}
	
	public String liesMeldung()
	{
		return meldung;
	}
}
