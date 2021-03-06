package miso.actions.keyboard;

import miso.utility.Scope;

public class TransFormat {
	private static TransFormat format = new TransFormat();

	public static TransFormat getInstance() {
		return format;
	}
	public int getVirtualCode(String data) {
		switch (data) {
		case "1":
			return 49;
		case "2":
			return 50;
		case "3":
			return 51;
		case "4":
			return 52;
		case "5":
			return 53;
		case "6":
			return 54;
		case "7":
			return 55;
		case "8":
			return 56;
		case "9":
			return 57;
		case "0":
			return 48;
		case "a":
			return 65;
		case "b":
			return 66;
		case "c":
			return 67;
		case "d":
			return 68;
		case "e":
			return 69;
		case "f":
			return 70;
		case "g":
			return 71;
		case "h":
			return 72;
		case "i":
			return 73;
		case "j":
			return 74;
		case "k":
			return 75;
		case "l":
			return 76;
		case "m":
			return 77;
		case "n":
			return 78;
		case "o":
			return 79;
		case "p":
			return 80;
		case "q":
			return 81;
		case "r":
			return 82;
		case "s":
			return 83;
		case "t":
			return 84;
		case "u":
			return 85;
		case "v":
			return 86;
		case "w":
			return 87;
		case "x":
			return 88;
		case "y":
			return 89;
		case "z":
			return 90;
		case "shift":
			return 160;
		case "ctrl":
			return 162;
		case "alt":
			return 164;
		case "F1":
			return 112;
		case "F2":
			return 113;
		case "F3":
			return 114;
		case "F4":
			return 115;
		case "F5":
			return 116;
		case "F6":
			return 117;
		case "F7":
			return 118;
		case "F8":
			return 119;
		case "F9":
			return 120;
		}
		return -1;
	}
	
	public String getVirtualChar(int data) {
		switch (data) {
		case 49:
			return "1";
		case 50:
			return "2";
		case 51:
			return "3";
		case 52:
			return "4";
		case 53:
			return "5";
		case 54:
			return "6";
		case 55:
			return "7";
		case 56:
			return "8";
		case 57:
			return "9";
		case 48:
			return "0";
		case 65:
			return "a";
		case 66:
			return "b";
		case 67:
			return "c";
		case 68:
			return "d";
		case 69:
			return "e";
		case 70:
			return "f";
		case 71:
			return "g";
		case 72:
			return "h";
		case 73:
			return "i";
		case 74:
			return "j";
		case 75:
			return "k";
		case 76:
			return "l";
		case 77:
			return "m";
		case 78:
			return "n";
		case 79:
			return "o";
		case 80:
			return "p";
		case 81:
			return "q";
		case 82:
			return "r";
		case 83:
			return "s";
		case 84:
			return "t";
		case 85:
			return "u";
		case 86:
			return "v";
		case 87:
			return "w";
		case 88:
			return "x";
		case 89:
			return "y";
		case 90:
			return "z";
		case 160:
			return "shift";
		case 162:
			return "ctrl";
		case 164:
			return "alt";
		case 112:
			return "F1";
		case 113:
			return "F2";
		case 114:
			return "F3";
		case 115:
			return "F4";
		case 116:
			return "F5";
		case 117:
			return "F6";
		case 118:
			return "F7";
		case 119:
			return "F8";
		case 120:
			return "F9";
		}
		return null;
	}
}
