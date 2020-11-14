import java.util.*;

public class Sms {
	
	/*
	 * Nam made this, delete later
	 */
	private static final int MAX_ATTEMPT = 5;
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		try {
			if (Authenticate.run(s) == MAX_ATTEMPT) throw new Exception();
			
			// rest of the code goes here
			System.out.println("Welcome!");
			
			
		} catch (Exception e) {		
			// I'm bored do whatever here I guess idc sry if it lags your system
			System.out.println("                              ...----....\r\n" + 
					"                         ..-:\"''         ''\"-..\r\n" + 
					"                      .-'                      '-.\r\n" + 
					"                    .'              .     .       '.\r\n" + 
					"                  .'   you shouldn't have done that.''.\r\n" + 
					"                .'  .    .       .   .   .     .   . ..:.\r\n" + 
					"              .' .   . .  .       .   .   ..  .   . ....::.\r\n" + 
					"             ..   .   .      .  .    .     .  ..  . ....:IA.\r\n" + 
					"            .:  .   .    .    .  .  .    .. .  .. .. ....:IA.\r\n" + 
					"           .: .   .   ..   .    .     . . .. . ... ....:.:VHA.\r\n" + 
					"           '..  .  .. .   .       .  . .. . .. . .....:.::IHHB.\r\n" + 
					"          .:. .  . .  . .   .  .  . . . ...:.:... .......:HIHMM.\r\n" + 
					"         .:.... .   . .\"::\"'.. .   .  . .:.:.:II;,. .. ..:IHIMMA\r\n" + 
					"         ':.:..  ..::IHHHHHI::. . .  ...:.::::.,,,. . ....VIMMHM\r\n" + 
					"        .:::I. .AHHHHHHHHHHAI::. .:...,:IIHHHHHHMMMHHL:. . VMMMM\r\n" + 
					"       .:.:V.:IVHHHHHHHMHMHHH::..:\" .:HIHHHHHHHHHHHHHMHHA. .VMMM.\r\n" + 
					"       :..V.:IVHHHHHMMHHHHHHHB... . .:VPHHMHHHMMHHHHHHHHHAI.:VMMI\r\n" + 
					"       ::V..:VIHHHHHHMMMHHHHHH. .   .I\":IIMHHMMHHHHHHHHHHHAPI:WMM\r\n" + 
					"       ::\". .:.HHHHHHHHMMHHHHHI.  . .:..I:MHMMHHHHHHHHHMHV:':H:WM\r\n" + 
					"       :: . :.::IIHHHHHHMMHHHHV  .ABA.:.:IMHMHMMMHMHHHHV:'. .IHWW\r\n" + 
					"       '.  ..:..:.:IHHHHHMMHV\" .AVMHMA.:.'VHMMMMHHHHHV:' .  :IHWV\r\n" + 
					"        :.  .:...:\".:.:TPP\"   .AVMMHMMA.:. \"VMMHHHP.:... .. :IVAI\r\n" + 
					"       .:.   '... .:\"'   .   ..HMMMHMMMA::. .\"VHHI:::....  .:IHW'\r\n" + 
					"       ...  .  . ..:IIPPIH: ..HMMMI.MMMV:I:.  .:ILLH:.. ...:I:IM\r\n" + 
					"     : .   .'\"' .:.V\". .. .  :HMMM:IMMMI::I. ..:HHIIPPHI::'.P:HM.\r\n" + 
					"     :.  .  .  .. ..:.. .    :AMMM IMMMM..:...:IV\":T::I::.\".:IHIMA\r\n" + 
					"     'V:.. .. . .. .  .  .   'VMMV..VMMV :....:V:.:..:....::IHHHMH\r\n" + 
					"       \"IHH:.II:.. .:. .  . . . \" :HB\"\" . . ..PI:.::.:::..:IHHMMV\"\r\n" + 
					"        :IP\"\"HHII:.  .  .    . . .'V:. . . ..:IH:.:.::IHIHHMMMMM\"\r\n" + 
					"        :V:. VIMA:I..  .     .  . .. . .  .:.I:I:..:IHHHHMMHHMMM\r\n" + 
					"        :\"VI:.VWMA::. .:      .   .. .:. ..:.I::.:IVHHHMMMHMMMMI\r\n" + 
					"        :.\"VIIHHMMA:.  .   .   .:  .:.. . .:.II:I:AMMMMMMHMMMMMI\r\n" + 
					"        :..VIHIHMMMI...::.,:.,:!\"I:!\"I!\"I!\"V:AI:VAMMMMMMHMMMMMM'\r\n" + 
					"        ':.:HIHIMHHA:\"!!\"I.:AXXXVVXXXXXXXA:.\"HPHIMMMMHHMHMMMMMV\r\n" + 
					"          V:H:I:MA:W'I :AXXXIXII:IIIISSSSSSXXA.I.VMMMHMHMMMMMM\r\n" + 
					"            'I::IVA ASSSSXSSSSBBSBMBSSSSSSBBMMMBS.VVMMHIMM'\"'\r\n" + 
					"             I:: VPAIMSSSSSSSSSBSSSMMBSSSBBMMMMXXI:MMHIMMI\r\n" + 
					"            .I::. \"H:XIIXBBMMMMMMMMMMMMMMMMMBXIXXMMPHIIMM'\r\n" + 
					"            :::I.  ':XSSXXIIIIXSSBMBSSXXXIIIXXSMMAMI:.IMM\r\n" + 
					"            :::I:.  .VSSSSSISISISSSBII:ISSSSBMMB:MI:..:MM\r\n" + 
					"            ::.I:.  ':\"SSSSSSSISISSXIIXSSSSBMMB:AHI:..MMM.\r\n" + 
					"            ::.I:. . ..:\"BBSSSSSSSSSSSSBBBMMMB:AHHI::.HMMI\r\n" + 
					"            :..::.  . ..::\":BBBBBSSBBBMMMB:MMMMHHII::IHHMI\r\n" + 
					"            ':.I:... ....:IHHHHHMMMMMMMMMMMMMMMHHIIIIHMMV\"\r\n" + 
					"              \"V:. ..:...:.IHHHMMMMMMMMMMMMMMMMHHHMHHMHP'\r\n" + 
					"               ':. .:::.:.::III::IHHHHMMMMMHMHMMHHHHM\"\r\n" + 
					"                 \"::....::.:::..:..::IIIIIHHHHMMMHHMV\"\r\n" + 
					"                   \"::.::.. .. .  ...:::IIHHMMMMHMV\"\r\n" + 
					"                     \"V::... . .I::IHHMMV\"'\r\n" + 
					"                       '\"VHVHHHAHHHHMMV:\"'");
		}
		StudentCourses s1 = new StudentCourses();
		s1.enroll();
	}
}
