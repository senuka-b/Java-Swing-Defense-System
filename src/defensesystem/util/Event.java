/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package defensesystem.util;

/**
 *
 * @author senuka
 */
public class Event {

    private int position = -1;
    private boolean areaCleared;
    private String chatText;
    private ChatTypeEnum chatType;
    private String chatSender; 
    private String objective;

    

    public static enum ChatTypeEnum {
        GENERAL, PRIVATE
    }

    public Event(String chatText, ChatTypeEnum chatType, String chatSender) {
        this.chatText = chatText;
        this.chatType = chatType;
        this.chatSender = chatSender;
    }
    
    public Event(boolean areaCleared) {
        this.areaCleared = areaCleared;
    }

    public Event(int position) {
        this.position = position;
    }
    
    public Event(String objective) {
        this.objective = objective;
    }
    
    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getChatSender() {
        return chatSender;
    }

    public void setChatSender(String chatSender) {
        this.chatSender = chatSender;
    }

  
    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @return the areaCleared
     */
    public boolean isAreaCleared() {
        return areaCleared;
    }

    /**
     * @param areaCleared the areaCleared to set
     */
    public void setAreaCleared(boolean areaCleared) {
        this.areaCleared = areaCleared;
    }

    /**
     * @return the chatText
     */
    public String getChatText() {
        return chatText;
    }

    /**
     * @param chatText the chatText to set
     */
    public void setChatText(String chatText) {
        this.chatText = chatText;
    }

    /**
     * @return the chatType
     */
    public ChatTypeEnum getChatType() {
        return chatType;
    }

    /**
     * @param chatType the chatType to set
     */
    public void setChatType(ChatTypeEnum chatType) {
        this.chatType = chatType;
    }

}
