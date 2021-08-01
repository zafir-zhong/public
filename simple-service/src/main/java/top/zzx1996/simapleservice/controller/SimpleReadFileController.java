package top.zzx1996.simapleservice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import top.zzx1996.simapleservice.dto.DTORequest;

import java.io.*;
import java.util.Set;

/**
 * 飞致云的模拟模拟数据
 *
 * @author ：zafir zhong
 * @version : 1.0.0
 * @date ：Created in 2021/6/3 下午4:07
 * @modified By：
 */
@RestController
public class SimpleReadFileController {

    @PostMapping("/readFile")
    public JSONObject getmsg(@RequestBody DTORequest request) {
        return read(request.isSuccess());
    }

    private JSONObject read(boolean success) {
        String fileName;

        if (success) {
            fileName = "success.txt";
        } else {
            fileName = "fail.txt";
        }

        File file = new File(fileName);
        if (!file.exists()) {
            return null;
        }
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            StringBuilder sb = new StringBuilder();
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                // 拼接换行符
                sb.append(temp).append("\n");
            }
            bufferedReader.close();
            return JSON.parseObject(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
