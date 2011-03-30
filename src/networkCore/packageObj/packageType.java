package networkCore.packageObj;

public enum packageType
{
    /* client->server*/
    LOGIN,  // userInfo
    CREAT_ROOM,    // String roomname
    JOIN_ROOM,   // String roomname
    LEAVE_ROOM, // String roomname
    CREAT_SECRET_ROOM,  // String roomname
    JOIN_SECRET_ROOM, // String username
    NOT_JOIN_SECRET_ROOM, // String roomname
    INVITE_SECRET_ROOM,  // String username, roomname
    FILE_SEND_REQUEST,
    VOICE_REQUEST,

    /* server->client*/
    LOGIN_SUCC,
    ERR_SAME_NAME,
    USER_INFO,   // userInfo
    USER_LOGOUT,    // String
    ROOM_INFO,   // String
    USER_JOIN_ROOM, // String username, roomname
    USER_LEAVE_ROOM, // String username, roomname
    USER_JOIN_SECRET_ROOM, // String username, roomname
    USER_LEAVE_SECRET_ROOM, // String username, roomname
    ASK_SECRET_ROOM, // String roomname
    ROOM_CLOSED, // String roomname
    MESSAGE,    // message
    CUT_OFF

    
    
}
