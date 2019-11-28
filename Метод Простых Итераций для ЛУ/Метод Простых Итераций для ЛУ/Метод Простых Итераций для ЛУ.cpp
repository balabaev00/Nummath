

#include "pch.h"
#include <iostream>
#include <math.h>

using namespace std;

double f(double x)
{
	return sqrt(x)+1-2*x;
}

int main()
{
	double x0 = 0.6, eps = 0.0001;
	double xOld;
	double xNew;
	xOld = x0;
	xNew = f(xOld);
	while (abs(xNew - xOld) > eps)
	{
		xOld = xNew;
		xNew = f(xOld);
		cout << xNew << endl;
		cout << xOld << endl;
	}
	cout << "Res" << xNew << endl;
	system("pause");
}

