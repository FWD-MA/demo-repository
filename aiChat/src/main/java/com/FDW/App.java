package com.FDW;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationParam;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesis;
import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesisParam;
import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesisResult;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/**
 * Hello world!
 *
 */
public class App 
{
    private static final OkHttpClient CLIENT = new OkHttpClient();
    private static final String MODEL = "stable-diffusion-xl";
    private static final String PROMPT = "一个母亲节的图片";
    private static final String SIZE = "1024*1024";
    public static void callWithMessage() throws NoApiKeyException, ApiException, InputRequiredException {
        Generation gen = new Generation();
        Scanner sc = new Scanner(System.in);
        List<Message> messages = new ArrayList<>();
        Message systemMsg = Message.builder().role(Role.SYSTEM.getValue()).content("You are a helpful assistant.").build();
        messages.add(systemMsg);
        while (true) {
            System.out.println("You:请输入...（exit退出）");
            String input = sc.next();
            if ("exit".equals(input)) {
                break;
            }
            Message userMsg = Message.builder().role(Role.USER.getValue()).content(input).build();
            if (messages.size() == 7) {
                messages.remove(0);
            }
            messages.add(userMsg);
            GenerationParam param = GenerationParam.builder()
                    .model("qwen-turbo")
                    .messages(messages)
                    .apiKey("sk-eb07a7232b0e4dbaa7d1f4ceec13965b")
                    .resultFormat(GenerationParam.ResultFormat.MESSAGE)
                    .topP(0.8)
                    .build();
            GenerationResult result = gen.call(param);
            System.out.println(result.getOutput().getChoices().get(0).getMessage().getContent());
            // 添加assistant返回到messages列表，user/assistant消息必须交替出现
            if (messages.size() == 7) {
                messages.remove(0);
            }
            messages.add(result.getOutput().getChoices().get(0).getMessage());
        }

    }
    public static void basicCall() throws ApiException, NoApiKeyException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("You:请输入...");
        String input = sc.next();
        ImageSynthesis is = new ImageSynthesis();
        ImageSynthesisParam param =
                ImageSynthesisParam.builder()
                        .model(ImageSynthesis.Models.WANX_V1)
                        .n(1)
                        .size("1024*1024")
                        .prompt(input)
                        .apiKey("sk-eb07a7232b0e4dbaa7d1f4ceec13965b")
                        .build();

        ImageSynthesisResult result = is.call(param);
        System.out.println(result);
    }

    public static void main( String[] args )
    {

        try{
            basicCall();
        }catch(ApiException|NoApiKeyException | IOException e){
            System.out.println(e.getMessage());
        }
        System.exit(0);

    }
}
