package gemeinsam;

@SuppressWarnings("serial")
public class ServerBotschaftTextnachricht extends Botschaft
{
	private String absender;
	private String empfaenger;
	private String textnachricht;
	
	public ServerBotschaftTextnachricht(String pAbsender, String pEmpfaenger,
			String pTextnachricht)
	{
		absender = pAbsender;
		empfaenger = pEmpfaenger;
		textnachricht = pTextnachricht;
	}
	
	public String liesAbsender()
	{
		return absender;
	}
	
	public String liesEmpfaenger()
	{
		return empfaenger;
	}
	
	public String liesTextnachricht()
	{
		return textnachricht;
	}
}
