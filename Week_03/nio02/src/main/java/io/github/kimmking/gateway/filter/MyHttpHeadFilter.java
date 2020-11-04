package io.github.kimmking.gateway.filter;

import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.channel.ChannelHandlerContext;

public class MyHttpHeadFilter implements HttpRequestFilter {
    private FullHttpRequest fullHttpRequest;

    public FullHttpRequest getFullHttpRequest(){
        return this.fullHttpRequest;
    };

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().add("nio","lipingping");
        this.fullHttpRequest = fullRequest;
    }
}
