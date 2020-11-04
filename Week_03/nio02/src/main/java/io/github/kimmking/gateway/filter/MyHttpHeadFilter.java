package io.github.kimmking.gateway.filter;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;

public class MyHttpHeadFilter implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().add("nio","lipingping");
    }

    @Override
    public ByteBuf content() {
        return null;
    }

    @Override
    public HttpHeaders trailingHeaders() {
        return null;
    }

    @Override
    public FullHttpRequest copy() {
        return null;
    }

    @Override
    public FullHttpRequest duplicate() {
        return null;
    }

    @Override
    public FullHttpRequest retainedDuplicate() {
        return null;
    }

    @Override
    public FullHttpRequest replace(ByteBuf byteBuf) {
        return null;
    }

    @Override
    public FullHttpRequest retain(int i) {
        return null;
    }

    @Override
    public int refCnt() {
        return 0;
    }

    @Override
    public FullHttpRequest retain() {
        return null;
    }

    @Override
    public FullHttpRequest touch() {
        return null;
    }

    @Override
    public FullHttpRequest touch(Object o) {
        return null;
    }

    @Override
    public boolean release() {
        return false;
    }

    @Override
    public boolean release(int i) {
        return false;
    }

    @Override
    public HttpVersion getProtocolVersion() {
        return null;
    }

    @Override
    public HttpVersion protocolVersion() {
        return null;
    }

    @Override
    public FullHttpRequest setProtocolVersion(HttpVersion httpVersion) {
        return null;
    }

    @Override
    public HttpHeaders headers() {
        return null;
    }

    @Override
    public HttpMethod getMethod() {
        return null;
    }

    @Override
    public HttpMethod method() {
        return null;
    }

    @Override
    public FullHttpRequest setMethod(HttpMethod httpMethod) {
        return null;
    }

    @Override
    public String getUri() {
        return null;
    }

    @Override
    public String uri() {
        return null;
    }

    @Override
    public FullHttpRequest setUri(String s) {
        return null;
    }

    @Override
    public DecoderResult getDecoderResult() {
        return null;
    }

    @Override
    public DecoderResult decoderResult() {
        return null;
    }

    @Override
    public void setDecoderResult(DecoderResult decoderResult) {

    }
}
