package com.hb0730.jsons;

/**
 * 异常
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/18
 * @since 1.0.0
 */
public class SimpleJsonException extends RuntimeException {
    public SimpleJsonException(String message) {
        super(message);
    }

    public SimpleJsonException(String message, Throwable cause) {
        super(message, cause);
    }

    public SimpleJsonException(Throwable cause) {
        super(cause);
    }
}
