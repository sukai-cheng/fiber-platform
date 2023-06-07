package com.ht.base.utils;

import org.ini4j.Ini;
import org.ini4j.Profile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 读取ini文件
 *
 * @author chengsukai
 */
public class Ini4jUtils {

    /**
     * 读取ini文件的内容
     *
     * @param iniFile     ini文件
     * @param fileContent ini文件中的key对应文件中的section，value对应i你文件section下的一个或多个key值
     * @return
     * @throws IOException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static Ini4jFileVo readIniFile(File iniFile, Map<String, List<String>> fileContent) throws IOException, NoSuchFieldException, IllegalAccessException {
        Ini4jFileVo fileVo = new Ini4jFileVo();
        Ini ini = new Ini();
        ini.load(iniFile);
        Profile.Section section = null;
        Field field = null;
        for (String key : fileContent.keySet()) {
            section = ini.get(key);
            for (String value : fileContent.get(key)) {
                field = fileVo.getClass().getDeclaredField(value);
                field.setAccessible(true);
                field.set(fileVo, section.get(value));
            }
        }
        return fileVo;
    }

    public static Ini4jFileVo getPropertiesFromIni() {
        File file = new File("screening/src/main/resources/config/MyApp.ini");
        Map<String, List<String>> fileContent = new HashMap<>();
        fileContent.put("config", Arrays.asList("Level2", "Defect", "Airline", "Tfzjxx", "Tfzjsx", "Lxzjxx", "Lxzjsx", "ntbh", "wtbh", "ksgl", "scgl", "Mjbh", "Velocity", "SStrain", "XStrain", "Level1", "SBBH"));
        fileContent.put("DDESection", Arrays.asList("Text80", "Text83", "Text84", "Text81", "Text82", "Text85", "Text86", "Text87", "Text88", "Text89", "Text810", "Text811", "Text812", "Text813", "Text814", "Text815", "Text816", "Text817", "Text818", "Text819", "Text820", "Text821", "Text822", "Text823", "Text824", "Text825", "Text826", "Text827", "Text828", "Text829", "Text830", "Text831", "Text836", "Text837"));
        Ini4jFileVo fileVo = null;
        try {
            fileVo = Ini4jUtils.readIniFile(file, fileContent);
        } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return fileVo;
    }
}
