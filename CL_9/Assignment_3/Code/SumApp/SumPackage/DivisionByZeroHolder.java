package SumApp.SumPackage;

/**
* SumApp/SumPackage/DivisionByZeroHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Sum.idl
* Sunday, May 16, 2021 7:49:16 PM IST
*/

public final class DivisionByZeroHolder implements org.omg.CORBA.portable.Streamable
{
  public SumApp.SumPackage.DivisionByZero value = null;

  public DivisionByZeroHolder ()
  {
  }

  public DivisionByZeroHolder (SumApp.SumPackage.DivisionByZero initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = SumApp.SumPackage.DivisionByZeroHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    SumApp.SumPackage.DivisionByZeroHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return SumApp.SumPackage.DivisionByZeroHelper.type ();
  }

}