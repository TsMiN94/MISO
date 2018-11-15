package miso.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import com.sun.org.apache.xpath.internal.operations.Bool;

import lc.kra.system.mouse.event.GlobalMouseEvent;
import miso.hook.MISOMouseHook;
import miso.resource.InputVirtualKeys;
import sun.net.www.content.text.plain;

public class PrefInfo {
	private String dicAPI;
	private String encAPI;
	private String imgAPI;
	private String videoAPI;
	private String trsAPI;
	private String mapAPI;
	private String ocrLanguage;

	private Vector<Integer> hotkey = new Vector<Integer>();
	private Vector<Boolean> hotkeyBool = new Vector<Boolean>();
	private Vector<Integer> setKey = new Vector<Integer>();
	private Vector<Boolean> setkeyBool = new Vector<Boolean>();
	private int ocrKey;
	private int mouse;

	private Scope scope = Scope.getInstace();
	private static final String prefInfo = "./preference/prefInfo.txt";
	private FileInputStream in = null;

	private boolean keySet=false;
	private boolean ocrSet=false;
	public PrefInfo() {
		try {
			File prefFile = new File(prefInfo);
			in = new FileInputStream(prefFile);
			byte bt[] = new byte[(int) prefFile.length()];

			in.read(bt);
			String doc = new String(bt);
			String[] line = doc.split("\n");
			for (int i = 0; i < line.length; i++) {
				String[] info = line[i].split(":");

				switch (info[0].trim()) {
				case "dic":
					dicAPI = info[1].trim();
					break;
				case "enc":
					encAPI = info[1].trim();
					break;
				case "img":
					imgAPI = info[1].trim();
					break;
				case "video":
					videoAPI = info[1].trim();
					break;
				case "trs":
					trsAPI = info[1].trim();
					break;
				case "map":
					mapAPI = info[1].trim();
					break;
				case "ocr":
					ocrKey = Integer.parseInt(info[1].trim());
					break;
				case "hot":
//					hotKey = Integer.parseInt(info[1].trim());
					String[] combination = info[1].split(",");
					for (int combIndex = 0; combIndex < combination.length; combIndex++) {
						hotkey.add(Integer.parseInt(combination[combIndex].trim()));
						hotkeyBool.add(false);
						System.out.println(hotkey.get(combIndex));
					}
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setDefault() {

		dicAPI = "Naver";
		encAPI = "Naver";
		imgAPI = "Naver";
		videoAPI = "Youtube";
		trsAPI = "Naver";
		mapAPI = "Google";

		ocrKey = InputVirtualKeys.KeyBoard_Shift;
		mouse = GlobalMouseEvent.BUTTON_MIDDLE;

	}

	public void load() {

		scope.getDicButton().setAPI(dicAPI);
		scope.getEncButton().setAPI(encAPI);
		scope.getImgButton().setAPI(imgAPI);
		scope.getVideoButton().setAPI(videoAPI);
		scope.getTlsButton().setAPI(trsAPI);
		scope.getMapButton().setAPI(mapAPI);

		// TODO set OCR language

	}

	public String getDicAPI() {
		return dicAPI;
	}

	public void setDicAPI(String dicAPI) {
		this.dicAPI = dicAPI;
	}

	public String getEncAPI() {
		return encAPI;
	}

	public void setEncAPI(String encAPI) {
		this.encAPI = encAPI;
	}

	public String getImgAPI() {
		return imgAPI;
	}

	public void setImgAPI(String imgAPI) {
		this.imgAPI = imgAPI;
	}

	public String getVideoAPI() {
		return videoAPI;
	}

	public void setVideoAPI(String videoAPI) {
		this.videoAPI = videoAPI;
	}

	public String getTrsAPI() {
		return trsAPI;
	}

	public void setTrsAPI(String tlsAPI) {
		this.trsAPI = tlsAPI;
	}

	public String getMapAPI() {
		return mapAPI;
	}

	public void setMapAPI(String mapAPI) {
		this.mapAPI = mapAPI;
	}

	public int getMouse() {
		return mouse;
	}

	public void setMouse(int mouse) {
		this.mouse = mouse;
	}

	public String getOcrLanguage() {
		return ocrLanguage;
	}

	public void setOcrLanguage(String ocrLanguage) {
		this.ocrLanguage = ocrLanguage;
	}

	/*
	 * public int getHotKey() { return hotKey; }
	 * 
	 * public void setHotKey(int hotKey) { this.hotKey = hotKey; }
	 */

	public int getOcrKey() {
		return ocrKey;
	}

	public Vector<Integer> getHotkey() {
		return hotkey;
	}

	public void setHotkey(Vector<Integer> hotkey) {
		this.hotkey = hotkey;
	}

	public Vector<Boolean> getHotkeybool() {
		return hotkeyBool;
	}

	public void setHotkeybool(Vector<Boolean> hotkeyBool) {
		this.hotkeyBool = hotkeyBool;
	}

	public void setOcrKey(int ocrKey) {
		this.ocrKey = ocrKey;
	}

	public boolean isKeySet() {
		return keySet;
	}

	public void setKeySet(boolean keySet) {
		this.keySet = keySet;
	}

	public Vector<Integer> getSetKey() {
		return setKey;
	}

	public void setSetKey(Vector<Integer> setKey) {
		this.setKey = setKey;
	}

	public Vector<Boolean> getSetkeyBool() {
		return setkeyBool;
	}

	public void setSetkeyBool(Vector<Boolean> setkeyBool) {
		this.setkeyBool = setkeyBool;
	}

	public boolean isOcrSet() {
		return ocrSet;
	}

	public void setOcrSet(boolean ocrSet) {
		this.ocrSet = ocrSet;
	}

}