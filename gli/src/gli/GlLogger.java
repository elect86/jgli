/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gli;

import com.jogamp.opengl.GL4;

/**
 *
 * @author GBarbieri
 */
public class GlLogger {

    public static void getMessages(GL4 gl4) {

        int[] nextMsgLength = new int[1];

        gl4.glGetIntegerv(GL4.GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH, nextMsgLength, 0);

        while (nextMsgLength[0] != 0) {

            int[] maxMsgLen = new int[1], sources = new int[1], types = new int[1],
                    ids = new int[1], severities = new int[1], lengths = new int[1];

            gl4.glGetIntegerv(GL4.GL_MAX_DEBUG_MESSAGE_LENGTH, maxMsgLen, 0);

            byte[] messageLog = new byte[nextMsgLength[0]];

            gl4.glGetDebugMessageLog(1, nextMsgLength[0], sources, 0,
                    types, 0, ids, 0, severities, 0, lengths, 0, messageLog, 0);

            System.out.println("source: " + getSource(sources[0]) + ", type: " + getType(types[0]) + ", id: " + ids[0]
                    + ", severity: " + getSeverity(severities[0]) + ", messageLog: " + new String(messageLog));

            gl4.glGetIntegerv(GL4.GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH, nextMsgLength, 0);
        }
    }

    private static String getSource(int sourceValue) {

        switch (sourceValue) {

            case GL4.GL_DEBUG_SOURCE_API:
                return "GL_DEBUG_SOURCE_API";

            case GL4.GL_DEBUG_SOURCE_SHADER_COMPILER:
                return "GL_DEBUG_SOURCE_SHADER_COMPILER";

            case GL4.GL_DEBUG_SOURCE_WINDOW_SYSTEM:
                return "GL_DEBUG_SOURCE_WINDOW_SYSTEM";

            case GL4.GL_DEBUG_SOURCE_THIRD_PARTY:
                return "GL_DEBUG_SOURCE_THIRD_PARTY";

            case GL4.GL_DEBUG_SOURCE_APPLICATION:
                return "GL_DEBUG_SOURCE_APPLICATION";

            case GL4.GL_DEBUG_SOURCE_OTHER:
                return "GL_DEBUG_SOURCE_OTHER";

            default:
                return "unknow";
        }
    }

    private static String getType(int typeValue) {

        switch (typeValue) {

            case GL4.GL_DEBUG_TYPE_ERROR:
                return "GL_DEBUG_TYPE_ERROR";

            case GL4.GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR:
                return "GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR";

            case GL4.GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR:
                return "GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR";

            case GL4.GL_DEBUG_TYPE_PERFORMANCE:
                return "GL_DEBUG_TYPE_PERFORMANCE";

            case GL4.GL_DEBUG_TYPE_PORTABILITY:
                return "GL_DEBUG_TYPE_PORTABILITY";

            case GL4.GL_DEBUG_TYPE_MARKER:
                return "GL_DEBUG_TYPE_MARKER";

            case GL4.GL_DEBUG_TYPE_PUSH_GROUP:
                return "GL_DEBUG_TYPE_PUSH_GROUP";

            case GL4.GL_DEBUG_TYPE_POP_GROUP:
                return "GL_DEBUG_TYPE_POP_GROUP";

            case GL4.GL_DEBUG_TYPE_OTHER:
                return "GL_DEBUG_TYPE_OTHER";

            default:
                return "unknow";
        }
    }

    private static String getSeverity(int severityValue) {

        switch (severityValue) {

            case GL4.GL_DEBUG_SEVERITY_HIGH:
                return "GL_DEBUG_SEVERITY_HIGH";

            case GL4.GL_DEBUG_SEVERITY_MEDIUM:
                return "GL_DEBUG_SEVERITY_MEDIUM ";

            case GL4.GL_DEBUG_SEVERITY_LOW:
                return "GL_DEBUG_SEVERITY_LOW";

            case GL4.GL_DEBUG_SEVERITY_NOTIFICATION:
                return "GL_DEBUG_SEVERITY_NOTIFICATION";

            default:
                return "unknow";
        }
    }
}
