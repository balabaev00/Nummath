#include "pch.h"
#include <iostream>
#include <math.h>

using namespace std;
double f(double x)
{
	return 4 * x + pow(2, x) + 6;
}
double df(double x)
{
	return  4 + pow(2, x)*log(2);
}

double dff(double x)
{
	return  pow(2, x)*pow(log(2), 2);
}

int main()
{
	double a = -2, b = -1, e = 0.0001;
	double d;
	double c;
	while (b - a > 2 * e)
	{
		if (f(a)*dff(a) > 0)
		{
			d = a - f(a) / df(a);
			c = (a*f(b) - b * f(a)) / (f(b) - f(a));
			a = d;
			b = c;
		}
		else
			if (f(b)*dff(b) > 0)
			{
				d = b - f(b) / df(b);
				c = (a*f(b) - b * f(a)) / (f(b) - f(a));
				b = d;
				a = c;
			}
	}
	cout << (a+b)/2 << endl;
	system("pause");
}