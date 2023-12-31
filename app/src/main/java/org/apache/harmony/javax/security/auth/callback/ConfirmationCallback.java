

package org.apache.harmony.javax.security.auth.callback;

import java.io.Serializable;

import org.apache.harmony.auth.internal.nls.Messages;

public class ConfirmationCallback implements Callback, Serializable {

    private static final long serialVersionUID = -9095656433782481624L;

    public static final int YES = 0;

    public static final int NO = 1;

    public static final int CANCEL = 2;

    public static final int OK = 3;

    public static final int YES_NO_OPTION = 0;

    public static final int YES_NO_CANCEL_OPTION = 1;

    public static final int OK_CANCEL_OPTION = 2;

    public static final int UNSPECIFIED_OPTION = -1;

    public static final int INFORMATION = 0;

    public static final int WARNING = 1;

    public static final int ERROR = 2;

    private String prompt;

    private int messageType;

    private int optionType = UNSPECIFIED_OPTION;

    private int defaultOption;

    private String[] options;

    private int selection;

    public ConfirmationCallback(int messageType, int optionType, int defaultOption) {
        super();
        if (messageType > ERROR || messageType < INFORMATION) {
            throw new IllegalArgumentException(Messages.getString("auth.16"));
        }

        switch (optionType) {
            case YES_NO_OPTION:
                if (defaultOption != YES && defaultOption != NO) {
                    throw new IllegalArgumentException(Messages.getString("auth.17"));
                }
                break;
            case YES_NO_CANCEL_OPTION:
                if (defaultOption != YES && defaultOption != NO && defaultOption != CANCEL) {
                    throw new IllegalArgumentException(Messages.getString("auth.17"));
                }
                break;
            case OK_CANCEL_OPTION:
                if (defaultOption != OK && defaultOption != CANCEL) {
                    throw new IllegalArgumentException(Messages.getString("auth.17"));
                }
                break;
            default:
                throw new IllegalArgumentException(Messages.getString("auth.18"));
        }
        this.messageType = messageType;
        this.optionType = optionType;
        this.defaultOption = defaultOption;
    }

    public ConfirmationCallback(int messageType, String[] options, int defaultOption) {
        super();
        if (messageType > ERROR || messageType < INFORMATION) {
            throw new IllegalArgumentException(Messages.getString("auth.16"));
        }

        if (options == null || options.length == 0) {
            throw new IllegalArgumentException(Messages.getString("auth.1A"));
        }
        for (int i = 0; i < options.length; i++) {
            if (options[i] == null || options[i].length() == 0) {
                throw new IllegalArgumentException(Messages.getString("auth.1A"));
            }
        }
        if (0 > defaultOption || defaultOption >= options.length) {
            throw new IllegalArgumentException(Messages.getString("auth.17"));
        }


        this.options = options;
        this.defaultOption = defaultOption;
        this.messageType = messageType;
    }

    public ConfirmationCallback(String prompt, int messageType, int optionType,
            int defaultOption) {
        super();
        if (prompt == null || prompt.length() == 0) {
            throw new IllegalArgumentException(Messages.getString("auth.14"));
        }

        if (messageType > ERROR || messageType < INFORMATION) {
            throw new IllegalArgumentException(Messages.getString("auth.16"));
        }

        switch (optionType) {
            case YES_NO_OPTION:
                if (defaultOption != YES && defaultOption != NO) {
                    throw new IllegalArgumentException(Messages.getString("auth.17"));
                }
                break;
            case YES_NO_CANCEL_OPTION:
                if (defaultOption != YES && defaultOption != NO && defaultOption != CANCEL) {
                    throw new IllegalArgumentException(Messages.getString("auth.17"));
                }
                break;
            case OK_CANCEL_OPTION:
                if (defaultOption != OK && defaultOption != CANCEL) {
                    throw new IllegalArgumentException(Messages.getString("auth.17"));
                }
                break;
            default:
                throw new IllegalArgumentException(Messages.getString("auth.18"));
        }
        this.prompt = prompt;
        this.messageType = messageType;
        this.optionType = optionType;
        this.defaultOption = defaultOption;
    }

    public ConfirmationCallback(String prompt, int messageType, String[] options,
            int defaultOption) {
        super();
        if (prompt == null || prompt.length() == 0) {
            throw new IllegalArgumentException(Messages.getString("auth.14"));
        }

        if (messageType > ERROR || messageType < INFORMATION) {
            throw new IllegalArgumentException(Messages.getString("auth.16"));
        }

        if (options == null || options.length == 0) {
            throw new IllegalArgumentException(Messages.getString("auth.1A"));
        }
        for (int i = 0; i < options.length; i++) {
            if (options[i] == null || options[i].length() == 0) {
                throw new IllegalArgumentException(Messages.getString("auth.1A"));
            }
        }
        if (0 > defaultOption || defaultOption >= options.length) {
            throw new IllegalArgumentException(Messages.getString("auth.17"));
        }


        this.options = options;
        this.defaultOption = defaultOption;
        this.messageType = messageType;
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public int getMessageType() {
        return messageType;
    }

    public int getDefaultOption() {
        return defaultOption;
    }

    public String[] getOptions() {
        return options;
    }

    public int getOptionType() {
        return optionType;
    }

    public int getSelectedIndex() {
        return selection;
    }

    public void setSelectedIndex(int selection) {
        if (options != null) {
            if (0 <= selection && selection <= options.length) {
                this.selection = selection;
            } else {
                throw new ArrayIndexOutOfBoundsException(Messages.getString("auth.1B"));
            }
        } else {
            switch (optionType) {
                case YES_NO_OPTION:
                    if (selection != YES && selection != NO) {
                        throw new IllegalArgumentException(Messages.getString("auth.19"));
                    }
                    break;
                case YES_NO_CANCEL_OPTION:
                    if (selection != YES && selection != NO && selection != CANCEL) {
                        throw new IllegalArgumentException(Messages.getString("auth.19"));
                    }
                    break;
                case OK_CANCEL_OPTION:
                    if (selection != OK && selection != CANCEL) {
                        throw new IllegalArgumentException(Messages.getString("auth.19"));
                    }
                    break;
            }
            this.selection = selection;
        }
    }
}
