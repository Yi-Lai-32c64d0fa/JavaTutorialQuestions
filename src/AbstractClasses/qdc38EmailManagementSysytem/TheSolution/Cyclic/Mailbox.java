package AbstractClasses.qdc38EmailManagementSysytem.TheSolution.Cyclic;

public class Mailbox {

  private String mailboxIdentifier;

  public Mailbox(String mailboxIdentifier) {
    this.mailboxIdentifier = mailboxIdentifier;
  }

  @Override
  public String toString() {
    return mailboxIdentifier;
  }


}