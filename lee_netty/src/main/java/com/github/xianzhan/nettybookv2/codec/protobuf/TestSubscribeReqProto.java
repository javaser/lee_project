package com.github.xianzhan.nettybookv2.codec.protobuf;

import com.github.xianzhan.nettybookv2.codec.protobuf.protobuf.SubscribeReqProto;
import com.google.protobuf.InvalidProtocolBufferException;

public class TestSubscribeReqProto {
    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto
                .SubscribeReq.newBuilder();
        builder.setSubReqID(1);
        builder.setUserName("Lixianzhan");
        builder.setProductName("Netty Book");
//        List<String> address = new ArrayList<>();
//        address.add("Huizhou");
//        address.add("Shenzhen");
//        address.add("Foshan");
//        builder.addAllAddress(address);
        builder.setAddress("Huizhou");
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("Before encode: " + req.toString());
        SubscribeReqProto.SubscribeReq req2 = decode(encode(req));
        System.out.println("After decode: " + req.toString());
        System.out.println("Assert equal: --> " + req2.equals(req));
    }
}
